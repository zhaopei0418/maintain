package online.zhaopei.myproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages = "online.zhaopei.myproject.mapper.para", sqlSessionFactoryRef = "paraSqlSessionFactory")
public class ParaDatabaseConfig {

	private static Logger logger = Logger.getLogger(ParaDatabaseConfig.class);
	
	@Bean(name = "paraDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.para")
	public DataSource paraDataSource() {
		return new DruidDataSource();
	}
	
	@Bean(name = "paraSqlSessionFactory")
	public SqlSessionFactory paraSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		logger.info("para sqlsession--" + this.paraDataSource().hashCode());
		sqlSessionFactoryBean.setDataSource(this.paraDataSource());
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("dialect", "oracle");
		properties.setProperty("pageSizeZero", "true");
		properties.setProperty("reasonable", "false");
		properties.setProperty("params", "pageNum=pageHelperStart;pageSize=pageHelperRows;");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "none");
		pageHelper.setProperties(properties);
		Interceptor[] interceptors = new Interceptor[] { pageHelper };
		sqlSessionFactoryBean.setPlugins(interceptors);
		return sqlSessionFactoryBean.getObject();
	}
	

	@Bean(name = "paraTxMan")
	public PlatformTransactionManager secondTransactionManager() {
		logger.info("para dataSource--" + this.paraDataSource().hashCode());
		return new DataSourceTransactionManager(this.paraDataSource());
	}
}
