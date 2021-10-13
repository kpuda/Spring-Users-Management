package com.example.demo.Repository;

import com.example.demo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    public StudentRepository studentRepository;

    @Test
    public void addStudent(){
        Student student= Student.builder()
                .name("kp")
                .surname("pk")
                .build();

        studentRepository.save(student);
    }

}