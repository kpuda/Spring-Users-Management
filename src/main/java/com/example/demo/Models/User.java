package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @SequenceGenerator(
            name = "student_id",
            sequenceName = "student_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_id")
    private Long userId;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(
                    name = "id",referencedColumnName = "id")
    )
    private Collection<Role> roles;
    private String city;
    private String street;
    private Integer streetNumber;
    private Integer houseNumber;
    private String postalCode;

/*
    @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id",referencedColumnName = "addressId")
        private Address address;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "people_address_map",
            joinColumns = @JoinColumn(
                    name = "address_id",
                    referencedColumnName = "addressId"),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"))
    private List<Student> student;
*/






}
