package com.spring;

import com.spring.dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentDaoConfig {
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }
}
