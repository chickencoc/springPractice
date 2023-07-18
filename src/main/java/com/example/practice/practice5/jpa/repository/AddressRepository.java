package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
