package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

/**
 * @Author WuRui
 * @ClassName TestSpring
 * @Date 2020/12/30 14:08
 * @Version 1.0
 * @Description //TODO
 **/
public class TestSpring {

    public static void main(String[] args) {
        System.setProperty("spring.active.profile", "default");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("${spring.active.profile}-beans.xml");

        Environment environment = ctx.getEnvironment();
        System.out.println(environment.getProperty("spring.active.profile"));
        System.out.println(environment.getProperty("M2_HOME"));
        System.out.println(environment.getProperty("GRADLE_USER_HOME"));
        System.out.println(environment.getProperty("CLASSPATH"));
        System.out.println(environment.getProperty("db.username"));
        ctx.registerShutdownHook();
    }
}
