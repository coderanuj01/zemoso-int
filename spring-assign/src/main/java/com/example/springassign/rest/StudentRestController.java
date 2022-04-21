package com.example.springassign.rest;

import com.example.springassign.entity.Student;
import com.example.springassign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    // add mapping for the get/student
    @GetMapping("/getStudents")
    public String getCustomers(Model theModel){

        List<Student> studentList = studentService.getStudents();

        // add customer to the model
        theModel.addAttribute("studentModel",studentList);

        return "student-list";
    }

    // get mapping to show customer adding form
    @GetMapping("/showFormToAddStu")
    public String showFormToAddStu(Model theModel){

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student",theStudent);

        return "student-form";
    }

    // add mapping for post/student ... add a new student
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student theStudent){

        // save student using the service
        studentService.saveStudent(theStudent);

        return "redirect:/api/getStudents";
    }

    // add mapping for put/customer ... update a customer
    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student theStudent){

        studentService.saveStudent(theStudent);

        return theStudent;
    }


}
