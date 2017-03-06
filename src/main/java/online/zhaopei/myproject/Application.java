package online.zhaopei.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import online.zhaopei.myproject.config.Md5PasswordConfig;
import online.zhaopei.myproject.service.MyFilterSecurityInterceptor;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService userDetailsService;

		@Autowired
		private Md5PasswordConfig md5PasswordConfig;
		
		@Autowired
		private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().ignoringAntMatchers("/wechat/**").and()
			.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
					.authorizeRequests()
					.antMatchers("/js/**", "/css/**", "/fonts/**",
						"/images/**", "/vendors/**", "/locales/**",
						"/favicon.ico", "/api/**", "/apidocs/**", "/wechat/**",
						"/invts/getStatisticsInOutInvtData",
						"/dists/exportExcludeInvts").permitAll()
					.anyRequest().authenticated().and()
					.formLogin().loginPage("/login").permitAll()
					.and().logout().permitAll();
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			// auth.inMemoryAuthentication().withUser("admin").password("zhaopei0408").roles("ADMIN");
			auth.userDetailsService(userDetailsService).passwordEncoder(md5PasswordConfig);
		}

	}
}
