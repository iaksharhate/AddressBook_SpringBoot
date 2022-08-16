package com.example.addressbookspringboot.repository;

import com.example.addressbookspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from addressbook where city = :city",nativeQuery = true)
    List<User> findByCity(String city);

    @Query(value = "select * from addressbook where state = :state",nativeQuery = true)
    List<User> findByState(String state);
}
