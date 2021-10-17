package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Models.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User saveStudent(UserDTO student);
    public User saveStudent(User student);


    public User findUserById(Long id);

    public List<User> fetchUserList();



    }

