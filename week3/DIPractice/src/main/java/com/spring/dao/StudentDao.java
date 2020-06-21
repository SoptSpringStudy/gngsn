package com.spring.dao;

import java.util.HashMap;
import java.util.Map;

public class StudentDao {
    private int key =0;
    private Map<String, Object> map = new HashMap<>();

    public void insert(Student student) {
        map.put(Integer.toString(key), student);
        key++;
        map.forEach((key, value) -> System.out.println("key : "+key+", value : "+((Student)value).getName()));
    }

    public void select(int studentKey) {
        Student student = (Student)map.get(Integer.toString(studentKey));
        System.out.println(student.getName()+" "+student.getAge()+" "+student.getSoptDept());
    }

}


