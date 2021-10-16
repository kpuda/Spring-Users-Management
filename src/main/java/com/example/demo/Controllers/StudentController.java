package com.example.demo.Controllers;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    private UserService studentService;

    public StudentController(UserService studentService) {
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


 /*   @PostMapping("/register")
    public String addPerson( Student student, BindingResult result, Model model) {

        return student.toString();
    }*/
}
