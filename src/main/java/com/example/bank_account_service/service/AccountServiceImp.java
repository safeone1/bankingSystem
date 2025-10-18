package com.example.bank_account_service.service;

import java.util.UUID;
import com.example.bank_account_service.repositories.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank_account_service.dto.BankAccountReqDTO;
import com.example.bank_account_service.dto.BankAccountResDTO;
import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.mappers.AccountMapper;


@Service
@Transactional
public class AccountServiceImp implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    AccountServiceImp(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountResDTO addAccount(BankAccountReqDTO accountDTO) {
        BankAccount bankAccount = BankAccount.builder()
        .id(UUID.randomUUID().toString())
        .createdAt(new java.util.Date())
        .updatedAt(new java.util.Date())
        .balance(accountDTO.getBalance())
        .currency(accountDTO.getCurrency())
        .type(accountDTO.getType())
        .build();
        
        BankAccount SavedBankAccount =  bankAccountRepository.save(bankAccount);

        BankAccountResDTO resdto = BankAccountResDTO.builder()
            .id(SavedBankAccount.getId())
            .createdAt(SavedBankAccount.getCreatedAt())
            .updatedAt(SavedBankAccount.getUpdatedAt())
            .balance(SavedBankAccount.getBalance())
            .currency(SavedBankAccount.getCurrency())
            .type(SavedBankAccount.getType())
                .build();
            
        BankAccountResDTO bnkaccresDto = accountMapper.fromBankAccountResDTO(SavedBankAccount);
        return bnkaccresDto; 
    }
}
