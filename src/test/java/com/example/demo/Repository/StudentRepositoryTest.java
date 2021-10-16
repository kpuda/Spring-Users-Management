package com.example.demo.Repository;

import com.example.demo.Models.Address;
import com.example.demo.Models.Student;
import com.example.demo.Service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    StudentServiceImpl studentService;

    @Test
    public void addStudent(){
        Address address=Address.builder()
                .city("Katowice")
                .street("Korfantego")
                .streetNumber(55)
                .houseNumber(25)
                .postalCode("44-213")
                .build();
        Student student= Student.builder()
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
        studentRepository.save(student);
    }

    @Test
    public void fetchStudents(){
        System.out.println("studentRepository = " + studentService.fetchStudentsList());
        System.out.println(studentRepository.findAll());
    }

}