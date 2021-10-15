package com.example.demo.Controllers;

import com.example.demo.Models.Address;
import com.example.demo.Models.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @Autowired
    StudentRepository repo;


    @GetMapping(path = "/students")
    public String showAllStudents(Model model){
        model.addAttribute("student",studentService.fetchStudentsList());

        System.out.println(repo.findAll());
        return "studentList";
    }
    @GetMapping(path = "/register")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("address",new Address());
        return "studentRegister";
    }


    @PostMapping("/register")
    public String addPerson( Student student, BindingResult result, Model model) {

        return student.toString();
    }
}
