package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @SequenceGenerator(
            name = "addres_id",
            sequenceName = "address_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "address_id")

    private Long addressId;
    private String city;
    private String street;
    private Integer streetNumber;
    private Integer houseNumber;
    private String postalCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "addressId")
    private List<User> students;

}
