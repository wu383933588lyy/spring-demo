package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * @Author WuRui
 * @ClassName TestPropertySource
 * @Date 2021/1/13 16:27
 * @Version 1.0
 * @Description //TODO
 **/
public class TestPropertySource {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Environment environment = context.getEnvironment();
        System.out.println(environment.getProperty("db.username"));
        context.close();
    }
}
