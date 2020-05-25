package com.spring.dao;
import com.spring.StudentModel;

import java.util.HashMap;
import java.util.Map;

public class StudentDao {
    private int key =0;
    private Map<String, Object> map = new HashMap<>();

    public void insert(StudentModel student) {
        map.put(Integer.toString(key), student);
        key++;
        map.forEach((key, value) -> System.out.println("key : "+key+", value : "+((StudentModel)value).getName()));
    }
}