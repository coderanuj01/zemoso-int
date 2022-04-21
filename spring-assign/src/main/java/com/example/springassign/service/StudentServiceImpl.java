package com.example.springassign.service;

import com.example.springassign.entity.Student;
import com.example.springassign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    // injecting student DAO
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student saveStudent(Student theStudent) {
        studentRepository.save(theStudent);
        return theStudent;
    }

    @Override
    @Transactional
    public Student getStudent(int theId) {
        return studentRepository.getById(theId);
    }


}
