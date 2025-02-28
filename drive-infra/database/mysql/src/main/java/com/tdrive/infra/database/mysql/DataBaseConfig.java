package com.tdrive.infra.database.mysql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@ConfigurationProperties(prefix = "spring.datasource")
public class DataBaseConfig {

//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Bean
//    public DataSource dataSource() {
//        System.out.println("url : "+url);
//        System.out.println("username : "+username);
//        System.out.println("password : "+password);
//        System.out.println("driverClassName : "+driverClassName);
//        return DataSourceBuilder.create()
//                .url(url)
//                .username(username)
//                .password(password)
//                .driverClassName(driverClassName)
//                .build();
//    }
}
