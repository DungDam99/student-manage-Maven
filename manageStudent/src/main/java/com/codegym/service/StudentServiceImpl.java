package com.codegym.service;

import com.codegym.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<Integer, Student> students;

    public StudentServiceImpl() {
        students = new HashMap<>();
        students.put(1, new Student(1, "A", 19, "A", false, "17T3"));
        students.put(2, new Student(2, "B", 19, "B", false, "17T3"));
        students.put(3, new Student(3, "C", 19, "C", false, "17T3"));
        students.put(4, new Student(4, "D", 19, "D", false, "17T3"));
        students.put(5, new Student(5, "E", 19, "E", false, "17T3"));
    }

    @Override
    public List<Student> list(){
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update( Student student) {
         students.remove(student.getId());
        students.put(student.getId(), student);
    }

    @Override
    public boolean isContains(int id){
        return students.containsValue(this.findById(id));
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
