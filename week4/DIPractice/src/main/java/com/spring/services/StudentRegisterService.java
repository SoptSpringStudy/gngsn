package com.spring.services;
import com.spring.dao.Student;
import com.spring.dao.StudentDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRegisterService implements InitializingBean, DisposableBean {
    static private StudentDao studentDao;

    public StudentRegisterService(){}

    @Autowired
    public StudentRegisterService(StudentDao studentDao){ this.studentDao = studentDao; }

    public static void register(Student student) {
        studentDao.insert(student);
        System.out.println("Main Dao 추가했습니다 ~");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean 객체 생성");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean 객체 소멸");
    }
}