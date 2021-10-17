package com.example.demo.Models;

import java.util.Collection;

public class UserDetails extends User{
    public UserDetails(Long userId, String name, String surname, String password, String email, String phoneNumber, Collection<Role> roles, String city, String street, Integer streetNumber, Integer houseNumber, String postalCode) {
        super(userId, name, surname, password, email, phoneNumber, roles, city, street, streetNumber, houseNumber, postalCode);
    }
}
