package com.codegym.model;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Repository;

@Repository
public class Student {

    @NotNull
    int id;

    @NotNull
    String name;

    @NotNull
    int age;

    @NotNull
    String address;

    @NotNull
    boolean sex;

    @NotNull
    String classroom;

    public Student() {
    }

    public Student(int id, String name, int age, String address, boolean sex, String classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
