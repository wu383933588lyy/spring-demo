package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @Author WuRui
 * @ClassName JavaConfig
 * @Date 2021/1/13 14:24
 * @Version 1.0
 * @Description //TODO
 **/
@Configuration
@ComponentScan(basePackages = "com.test")
@PropertySource(value = "classpath:jdbc.properties")
public class JavaConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
