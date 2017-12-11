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
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/shopping?createDatabaseIfNotExist=true";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "";

	
	@Bean("dataSource")
	public DataSource getDataSource() {

		/*BasicDataSource dataSource = new BasicDataSource();*/

        String dbUrl = DATABASE_URL;
        String username = DATABASE_USERNAME;
        String password = DATABASE_PASSWORD;

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(DATABASE_DRIVER);
        basicDataSource.setUrl(DATABASE_URL);
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
