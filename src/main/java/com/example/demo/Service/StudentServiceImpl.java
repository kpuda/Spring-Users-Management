package com.example.demo.Service;

import com.example.demo.Models.Role;
import com.example.demo.Models.Student;
import com.example.demo.Models.StudentWeb;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentServiceImpl implements UserService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Student saveStudent(StudentWeb studentWeb) {
        Student student= Student.builder()
                .name(studentWeb.getName())
                .surname(studentWeb.getSurname())
                .email(studentWeb.getEmail())
                .password(studentWeb.getPassword())
                .roles(Arrays.asList((new Role("ROLE_STUDENT"))))
                .build();
        return studentRepository.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student=studentRepository.findByEmail(s);
        if (student==null){
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(student.getEmail(),student.getPassword(), maRolesToAuthorities(student.getRoles()));
    }
    private Collection<? extends GrantedAuthority> maRolesToAuthorities(Collection<Role> roles){
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Student> fetchStudentsList() {
        return studentRepository.findAll();
    }
}
