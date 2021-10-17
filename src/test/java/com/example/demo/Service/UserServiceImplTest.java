package com.example.demo.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    public UserServiceImpl userService;

    @Test
    public void finduserById(){
        System.out.println(userService.findUserById(19L));
    }
}