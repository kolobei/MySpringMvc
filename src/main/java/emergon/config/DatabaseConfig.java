/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.config;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author gkolo
 */
@Configuration
@EnableTransactionManagement // Inform spring container to take into account annotations about @Transactional
public class DatabaseConfig {

    // datasource
    public DataSource getDatasource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/sales1?serverTimezone=Europe/Athens");
        datasource.setUsername("root");
        datasource.setPassword("JulyGeorge27");
        return datasource;
    }

    // hibernate properties
    private Properties getHibernateProperties() {

        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }

    //SessionFactory
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        DataSource datasource = getDatasource();
        sessionFactory.setDataSource(datasource);

        Properties properties = getHibernateProperties();
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan("emergon.entity");

        return sessionFactory;
    }
    
    // method to take care of transactions
    @Bean // Make HibernateTransactionManager a bean in order to go into Spring Manager
    @Autowired // inkjet SessionFactory into that method
    public HibernateTransactionManager transactionManager(SessionFactory sf){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sf);
        return txManager;
    }
}
