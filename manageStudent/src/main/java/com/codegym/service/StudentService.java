package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> list();

    void save(Student student);

    Student findById(int id);

    void update(Student student);

    boolean isContains(int id);

    void remove(int id);
}
