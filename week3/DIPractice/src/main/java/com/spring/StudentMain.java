package com.spring;

import com.spring.dao.Student;
import com.spring.services.StudentRegisterService;
import com.spring.services.StudentSearchService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        String[] name = {"mj", "gs", "dk", "hs", "hw"};
        int[] age = {24, 23, 26, 24, 24};
        String[] soptDept = {"server", "server", "server", "android", "android"};
        String[] ctxs = {"classpath:appContext.xml"};
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(ctxs);

        StudentRegisterService registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
        for (int i =0; i < name.length; i++) {
            Student student = new Student(name[i], age[i], soptDept[i]);
            registerService.register(student);
        }
        StudentSearchService searchService = ctx.getBean("studentSearchService", StudentSearchService.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 학생의 키를 입력하세요.");
        String key = sc.next();
        searchService.search(Integer.parseInt(key));
        ctx.close();
    }
}
