package example.com.onlineshoppingapplicationbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "example.com.onlineshoppingapplicationbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

/*	private final static String DATABASE_URL = "postgres://sgxuzxwstkiiip:c48eb89c77a06613e097f6f192353c59de50d8a2230b9d0dc297232c6a4dbfa0@ec2-107-22-235-167.compute-1.amazonaws.com:5432/d3doq2hifk108v";
	private final static String DATABASE_DRIVER = "org.postgresql.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sgxuzxwstkiiip";
	private final static String DATABASE_PASSWORD = "c48eb89c77a06613e097f6f192353c59de50d8a2230b9d0dc297232c6a4dbfa0";
*/
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	@Bean("dataSource")
	public DataSource getDataSource() {

		/*BasicDataSource dataSource = new BasicDataSource();*/

        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
		
		return basicDataSource;

	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("example.com.onlineshoppingapplicationbackend.dto" );
		return builder.buildSessionFactory();
		
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");		
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransacationManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
		
	}
}
