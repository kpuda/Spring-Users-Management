package com.example.demo.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    public void deleteUser(){
        userRepository.deleteById(18L);
    }
}