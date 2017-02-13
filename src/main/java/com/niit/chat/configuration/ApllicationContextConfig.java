package com.niit.chat.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niii.chat.model.AnswerForum;
import com.niii.chat.model.Blog;
import com.niii.chat.model.BlogComment;
import com.niii.chat.model.Forum;
import com.niii.chat.model.Friend;
import com.niii.chat.model.Jobs;
import com.niii.chat.model.Users;



@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ApllicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDatasource(){
		DriverManagerDataSource dmd=new DriverManagerDataSource();
		dmd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dmd.setUrl("jdbc:oracle:thin:@//localhost:1521/XE ");
		dmd.setUsername("CHYD");
        dmd.setPassword("admin");
        System.out.println("datasource");
		return dmd;		
		
		
	}
	
	public Properties getHibernateProperties(){
		
		Properties p=new Properties();
     p.setProperty("hibernate.hbm2ddl.auto", "update"); 
		

		p.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		
		
        System.out.println("properties Flink");

		return p;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Users.class);
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(Jobs.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		localSessionFactoryBuilder.addAnnotatedClass(AnswerForum.class);
		
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}


}
