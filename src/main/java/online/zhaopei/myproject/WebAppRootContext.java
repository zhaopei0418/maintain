package online.zhaopei.myproject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@ServletComponentScan
@Configuration
@EnableAutoConfiguration
public class WebAppRootContext implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		System.out.println("=============boot start");
	}

}
