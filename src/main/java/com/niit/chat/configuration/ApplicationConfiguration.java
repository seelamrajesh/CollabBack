package com.niit.chat.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class ApplicationConfiguration {
	@EnableWebMvc
	@Configuration
	@ComponentScan(basePackages="com.niit.chat.configuration")
	public class ChatBucketConfiguration {

}
}
