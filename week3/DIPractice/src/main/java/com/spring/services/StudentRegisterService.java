package com.spring.services;
import com.spring.dao.Student;
import com.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRegisterService {
    static private StudentDao studentDao;

    public StudentRegisterService(){}

    @Autowired
    public StudentRegisterService(StudentDao studentDao){ this.studentDao = studentDao; }

    public static void register(Student student) {
        studentDao.insert(student);
        System.out.println("Main Dao 추가했습니다 ~");
    }
}