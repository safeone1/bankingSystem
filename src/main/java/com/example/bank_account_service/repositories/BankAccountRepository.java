package com.example.bank_account_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.enums.AccountType;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    @RestResource(path = "/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
    List<BankAccount> findByCurrency(String currency);
    List<BankAccount> findByBalanceGreaterThan(double balance);
    
}
