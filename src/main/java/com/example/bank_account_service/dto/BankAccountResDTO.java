package com.example.bank_account_service.dto;

import java.util.Date;

import com.example.bank_account_service.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResDTO {
private String id;
    private Date createdAt;
    private Date updatedAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
