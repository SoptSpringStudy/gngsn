package com.spring;

import com.spring.services.StudentService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {
    public static void main(String[] args) {
        String[] ctxs = {"classpath:appContext1.xml", "classpath:appContext2.xml", "classpath:appContext3.xml"};
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(ctxs);

        StudentService studentService = ctx.getBean("studentService", StudentService.class);
        StudentModel student1 = ctx.getBean("student1", StudentModel.class);
        StudentModel student2 = ctx.getBean("student2", StudentModel.class);
        studentService.register(student1);
        studentService.register(student2);
    }
}
