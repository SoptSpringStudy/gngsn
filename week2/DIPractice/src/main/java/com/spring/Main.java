package com.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
                "classpath:applicationContext.xml");
        StudentModel pm = ctx.getBean("Itsme", StudentModel.class);
        pm.introMyself();
    }
}
