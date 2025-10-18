package com.example.bank_account_service.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_account_service.dto.BankAccountReqDTO;
import com.example.bank_account_service.dto.BankAccountResDTO;
import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.repositories.BankAccountRepository;
import com.example.bank_account_service.service.AccountService;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;

    }


        @GetMapping("/bankAccounts")
        public List<BankAccount> bankAccounts() {
            return bankAccountRepository.findAll();
        }

        @GetMapping("/bankAccounts/{id}")   
        public BankAccount bankAccount(@PathVariable String id) {
            return bankAccountRepository.findById(id).orElse(null);
        }
    

        @PostMapping("/bankAccounts")
        public BankAccountResDTO save(@RequestBody BankAccountReqDTO bankAccount) {
            return accountService.addAccount(bankAccount);
        }

        @PutMapping("bankAccounts/{id}")
        public String update(@PathVariable String id, @RequestBody BankAccount entity) {

            BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow();

            if (entity.getBalance() != null) {
                bankAccount.setBalance(entity.getBalance());
            }
            if (entity.getCurrency() != null) {
                bankAccount.setCurrency(entity.getCurrency());
            }
            if (entity.getType() != null) {
                bankAccount.setType(entity.getType());
            }
            bankAccount.setUpdatedAt(new Date());
            return bankAccountRepository.save(bankAccount).getId();
        }
        

        @DeleteMapping("/bankAccounts/{id}")
        public void delete(@PathVariable String id) {
            bankAccountRepository.deleteById(id);
        }
    
}
