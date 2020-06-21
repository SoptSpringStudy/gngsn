package com.spring;

import com.spring.dao.Student;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
                "classpath:applicationContext.xml");
        Student pm = ctx.getBean("Itsme", Student.class);
        pm.introMyself();
    }
}
