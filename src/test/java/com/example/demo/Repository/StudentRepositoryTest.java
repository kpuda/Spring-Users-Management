package com.example.demo.Repository;

import com.example.demo.Models.Address;
import com.example.demo.Models.User;
import com.example.demo.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    UserServiceImpl userService;

    @Test
    public void addStudent(){
        Address address=Address.builder()
                .city("Katowice")
                .street("Korfantego")
                .streetNumber(55)
                .houseNumber(25)
                .postalCode("44-213")
                .build();
        User student= User.builder()
                .name("Michelle")
                .surname("Jenson")
                .phoneNumber("432412543")
                .email("mjenson@gmail.com")
                .city("Katowice")
                .street("Korfanteg")
                .streetNumber(55)
                .houseNumber(21)
                .postalCode("22-452")
                .build();


        System.out.println(address);
        System.out.println(student);
        userRepository.save(student);
    }

    @Test
    public void fetchStudents(){
        System.out.println("studentRepository = " + userService.fetchUserList());
        System.out.println(userRepository.findAll());
    }

    @Test
    public void getStudents(){
        System.out.println(userRepository.getStudents());
    }

    @Test
    public void findById(){
        System.out.println(userRepository.findUserById(19L));
    }



}