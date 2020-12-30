package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author WuRui
 * @ClassName TestSpring
 * @Date 2020/12/30 14:08
 * @Version 1.0
 * @Description //TODO
 **/
public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(ctx.getId());
        TestBean testB1 = (TestBean) ctx.getBean("testB1");
        testB1.test();
    }
}
