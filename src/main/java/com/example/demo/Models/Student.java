package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_id",
            sequenceName = "student_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_id")
    private Long studentId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Address address;


//    @ManyToOne
//    @JoinColumn(name = "address_id",referencedColumnName = "addressId")
//    private Address address;

  /*  @ManyToMany(cascade = CascadeType.ALL)
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
