package com.example.demo.Service;

import com.example.demo.Models.Student;
import com.example.demo.Models.StudentWeb;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    public Student saveStudent(StudentWeb student);

    public List<Student> fetchStudentsList();

    }

