package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    UserRepository repo;


    //Students list
    @GetMapping(path = "/students")
    public String showAllStudents(Model model){
        model.addAttribute("user", repo.getStudents());
        System.out.println(repo.getStudents());
        return "studentList";
    }


    //Editing student
    @GetMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id){
        ModelAndView mv=new ModelAndView("edit");
        User user=userService.findUserById(id);
    mv.addObject("user",user);
        System.out.println(user.getRoles());
    return mv;
    }

    //Saving student
    /*@PutMapping("/save")
    public String saveUser(@RequestBody User user,@PathVariable("userId") Long id){
        this.userRepository.update(user,id);
        return "redirect:/";
    }*/
    //Deleting user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes){
        this.userRepository.deleteById(id);
        if (userRepository.findUserById(id)==null) {
            redirectAttributes.addFlashAttribute("success", "User with ID: " + id + " has been deleted successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Something went wrong. User has not been deleted.");
        }
        return "redirect:/students";
    }

}
