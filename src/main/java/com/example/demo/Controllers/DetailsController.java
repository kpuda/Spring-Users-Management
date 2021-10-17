package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailsController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

//TODO
@GetMapping("/details/{id}")
public ModelAndView editUser(@PathVariable(name = "id") Long id){
    ModelAndView mv=new ModelAndView("details");
    User user=userService.findUserById(id);
    mv.addObject("user",user);
    return mv;
}
    @PostMapping("/details/save")
    public String saveUser(@ModelAttribute("User") User user){
        userRepository.save(user);

        return "redirect:/";

    }
}
