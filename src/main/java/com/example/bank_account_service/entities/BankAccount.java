package com.example.bank_account_service.entities;

import java.util.Date;

import com.example.bank_account_service.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

    @Id
    // @GeneratedValue(strategy = GenerationType.UUID) 
    
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
