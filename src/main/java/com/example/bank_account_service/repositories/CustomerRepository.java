package com.example.bank_account_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.bank_account_service.entities.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
