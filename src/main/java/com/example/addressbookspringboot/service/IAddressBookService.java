package com.example.addressbookspringboot.service;

import com.example.addressbookspringboot.dto.UserDTO;
import com.example.addressbookspringboot.model.User;

import java.util.List;

public interface IAddressBookService {
    List<User> getUserData();

    User getUserDataById(int id);

    User createUserData(UserDTO userDTO);

    User updateUserData(Integer id, UserDTO userDTO);

    void deleteUserData(Integer id);

    List<User> findByCityData(String city);

    List<User> findByStateData(String state);
}
