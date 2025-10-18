package com.example.bank_account_service.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.bank_account_service.dto.BankAccountResDTO;
import com.example.bank_account_service.entities.BankAccount;

@Component
public class AccountMapper {

    public BankAccountResDTO fromBankAccountResDTO(BankAccount bankAccount) {

        BankAccountResDTO bankAccountResDto = new BankAccountResDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResDto);
        return bankAccountResDto;
    }
}
