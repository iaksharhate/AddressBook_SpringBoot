package com.example.addressbookspringboot.service;

import com.example.addressbookspringboot.dto.UserDTO;
import com.example.addressbookspringboot.model.User;
import com.example.addressbookspringboot.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class addressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository repository;

    @Override
    public List<User> getUserData() {
        return repository.findAll();
    }

    @Override
    public User getUserDataById(int id) {
        return repository.findById(id)
                         .orElseThrow(() -> new ArithmeticException("User with ID "+
                                 id +" does not exist."));
    }

    @Override
    public User createUserData(UserDTO userDTO) {
        User user = null;
        user = new User(userDTO);
        return repository.save(user);
    }

    @Override
    public User updateUserData(Integer id, UserDTO userDTO) {
        User user = this.getUserDataById(id);
        user.updateUser(userDTO);
        return repository.save(user);
    }

    @Override
    public void deleteUserData(Integer id) {
        User user = this.getUserDataById(id);;
        repository.delete(user);
    }

    @Override
    public List<User> findByCityData(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<User> findByStateData(String state) {
        return repository.findByState(state);
    }
}
