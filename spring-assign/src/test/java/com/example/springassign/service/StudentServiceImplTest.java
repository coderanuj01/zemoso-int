package com.example.springassign.service;

import com.example.springassign.entity.Student;
import com.example.springassign.repository.ItemRepository;
import com.example.springassign.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentServiceImpl studentServiceImpl;

    @BeforeEach
    void setUp() {
        this.studentServiceImpl = new StudentServiceImpl(studentRepository);
    }

    @Test
    void getStudents() {

        studentServiceImpl.getStudents();
        verify(studentRepository).findAll();

    }

    @Test
    void saveStudent() {

        Student student = new Student();
        student.setId(1);
        student.setEnrollNo("65463");
        student.setFirstName("John");
        student.setLastName("Doe");

        Mockito.when(studentRepository.save(student)).thenReturn(student);
        assertThat(studentServiceImpl.saveStudent(student)).isEqualTo(student);

    }

    @Test
    void getStudent() {

        Student student = new Student();
        student.setId(1);
        student.setEnrollNo("65463");
        student.setFirstName("John");
        student.setLastName("Doe");

        Mockito.when(studentRepository.getById(1)).thenReturn(student);
        assertThat(studentServiceImpl.getStudent(1)).isEqualTo(student);

    }

}