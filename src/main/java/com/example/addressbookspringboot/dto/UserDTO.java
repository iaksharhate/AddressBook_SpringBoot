package com.example.addressbookspringboot.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public @ToString class UserDTO {

    public int id;
//    @NotEmpty(message="First name cannot null")
//    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name is invalid")
    public String name;
//    @NotNull(message = "Phone No cannot be null.")
//    @Pattern(regexp = "^[0-9]{2}\\s{0,1}[0-9]{10}$",message = "Phone No Is Invalid")
    public String phoneNumber;

    public String address;
//    @NotNull(message = "City cannot be null.")
//    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City Is Invalid")
    public String city;
//    @NotNull(message = "State No cannot be null.")
//    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "State Is Invalid")
    public String state;
//    @NotNull(message = "Zip code No cannot be blank.")
//    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$",message = "Zip Code Is Invalid")
    public String zip;
}
