package com.example.addressbookspringboot.model;

import com.example.addressbookspringboot.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addressbook")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;

    public User(UserDTO userDTO) {
        this.updateUser(userDTO);
    }

    public void updateUser(UserDTO userDTO){
        this.name = userDTO.name;
        this.phoneNumber = userDTO.phoneNumber;
        this.address = userDTO.address;
        this.city = userDTO.city;
        this.state = userDTO.state;
        this.zip = userDTO.zip;
    }
}
