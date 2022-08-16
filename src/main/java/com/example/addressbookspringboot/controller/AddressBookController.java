package com.example.addressbookspringboot.controller;

import com.example.addressbookspringboot.dto.ResponseDTO;
import com.example.addressbookspringboot.dto.UserDTO;
import com.example.addressbookspringboot.model.User;
import com.example.addressbookspringboot.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getUserData() {
        List<User> userList = null;
        userList = addressBookService.getUserData();
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", userList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getUserData(@PathVariable(value = "id") int id) {
        User user = null;
        user = addressBookService.getUserDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id successful ", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addUserData(@Valid @RequestBody UserDTO userDTO) {
        User user = null;
        user = addressBookService.createUserData(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created AddressBook data successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUserData(@Valid @PathVariable("id") Integer id,
                                                          @RequestBody UserDTO userDTO) {
        User user = null;
        user = addressBookService.updateUserData(id, userDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated AddressBook Data Successfully", user);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Integer id) {
        addressBookService.deleteUserData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully", "Deleted id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getByCity(@PathVariable("city") String city) {
        List<User> userDataList = null;
        userDataList = addressBookService.findByCityData(city);
        ResponseDTO responseDTO = new ResponseDTO("Get Call by city Successful", userDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getByState(@PathVariable("state") String state) {
        List<User> userDataList = null;
        userDataList = addressBookService.findByStateData(state);
        ResponseDTO responseDTO= new ResponseDTO("Get Call by state Successful", userDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
