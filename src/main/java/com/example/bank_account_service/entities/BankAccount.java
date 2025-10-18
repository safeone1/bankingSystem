package com.example.bank_account_service.entities;

import java.util.Date;

import com.example.bank_account_service.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType type;
}
