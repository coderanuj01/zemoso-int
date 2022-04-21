package com.example.springassign.service;

import com.example.springassign.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student saveStudent(Student theStudent);

    Student getStudent(int theId);
}
