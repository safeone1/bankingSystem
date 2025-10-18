package com.example.bank_account_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_account_service.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    
}
