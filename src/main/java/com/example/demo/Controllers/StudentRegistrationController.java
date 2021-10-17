package com.example.demo.Controllers;


import com.example.demo.Models.User;
import com.example.demo.Models.UserDTO;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class StudentRegistrationController {

    private UserService studentService;

    @Autowired
    public StudentRegistrationController(UserService studentService) {
        this.studentService = studentService;
    }

    @ModelAttribute("student")
    public UserDTO studentWebRegistraiton(){
    return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String registerStudent(@ModelAttribute("user") UserDTO studentWeb){
        studentService.saveStudent(studentWeb);
        return "redirect:/login?success";
    }
}
