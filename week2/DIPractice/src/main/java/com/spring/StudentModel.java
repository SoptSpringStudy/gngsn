package com.spring;

import java.util.List;
import java.util.Map;

public class StudentModel {
    private String name;
    private Integer age;
    private String soptDept;
    private List<String> Friends;
    private Map<String, String> proLangs;

    public StudentModel() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSoptDept(String soptDept) {
        this.soptDept = soptDept;
    }

    public void setFriends(List<String> friends) {
        Friends = friends;
    }

    public void setProLangs(Map<String, String> proLangs) {
        this.proLangs = proLangs;
    }

    public void introMyself() {
        System.out.println("name : "+name);
        System.out.println("age : "+age);
        System.out.println("sopt-dept : " + soptDept);
        System.out.println("friends : "+ Friends);
        System.out.println("lang : "+ proLangs);
    }
}
