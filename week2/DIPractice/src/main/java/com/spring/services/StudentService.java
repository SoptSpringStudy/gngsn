package com.spring.services;
import com.spring.StudentModel;
import com.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    static private StudentDao studentDao;

    public StudentService(){}

    @Autowired
    public StudentService(StudentDao studentDao){ this.studentDao = studentDao; }

    public static void register(StudentModel student) {
        studentDao.insert(student);
        System.out.println("Main Dao 추가했습니다 ~");
    }
}