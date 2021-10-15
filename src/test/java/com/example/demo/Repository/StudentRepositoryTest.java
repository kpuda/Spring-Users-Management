package com.example.demo.Repository;

import com.example.demo.Models.Address;
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
        Address address=Address.builder()
                .city("Katowice")
                .street("Korfantego")
                .streetNumber(55)

                .build();
        Student student= Student.builder()
                .name("Michelle")
                .surname("Jenson")
                .phoneNumber("432412543")
                .email("mjenson@gmail.com")
                .address(address)
                .build();

        System.out.println(student.getAddress().getCity());
        studentRepository.save(student);
    }

}