package com.spring;

import com.spring.dao.StudentDao;
import com.spring.services.StudentRegisterService;
import com.spring.services.StudentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 스프링 설정 파일임을 알려주는 어노테이션
@Configuration
@Import(StudentDaoConfig.class)
public class StudentConfig {
    @Autowired
    StudentDao studentDao;

    @Bean
    public StudentRegisterService studentRegisterService() {
        return new StudentRegisterService(studentDao);
    }

    @Bean
    public StudentSearchService studentSearchService() {
        return new StudentSearchService(studentDao);
    }
}
