package com.example.bank_account_service.service;

import com.example.bank_account_service.dto.BankAccountReqDTO;
import com.example.bank_account_service.dto.BankAccountResDTO;

public interface AccountService {

    public BankAccountResDTO addAccount(BankAccountReqDTO accountDTO);
}
