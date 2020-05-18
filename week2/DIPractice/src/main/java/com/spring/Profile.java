package com.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Profile {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
                "classpath:applicationContext.xml");
        ProfileModel pm = ctx.getBean("Itsme", ProfileModel.class);
        pm.introMyself();
    }
}
