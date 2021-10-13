package com.example.demo.Service;

import com.example.demo.Models.Student;

import java.util.List;

public interface StudentService {


    public Student saveStudent(Student student);

    public List<Student> fetchStudentsList();

    }

