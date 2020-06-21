package com.spring.services;
import com.spring.dao.Student;
import com.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentSearchService {
    static private StudentDao studentDao;

    public StudentSearchService(){}

    @Autowired
    public StudentSearchService(StudentDao studentDao){ this.studentDao = studentDao; }

    public static void search(int key) {

        studentDao.select(key);
        System.out.println("학생 검색을 성공했습니다.");
    }
}