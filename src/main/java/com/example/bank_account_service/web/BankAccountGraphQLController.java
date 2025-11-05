package com.example.bank_account_service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.entities.Customer;
import com.example.bank_account_service.enums.AccountType;
import com.example.bank_account_service.repositories.BankAccountRepository;
import com.example.bank_account_service.repositories.CustomerRepository;

@Controller
public class BankAccountGraphQLController {


    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    @QueryMapping
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
    

    @MutationMapping
    public BankAccount addBankAccount(@Argument BankAccountInput input) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCurrency(input.currency());
        bankAccount.setType(input.type());
        bankAccount.setBalance(input.balance());
        return bankAccountRepository.save(bankAccount);
    }

    @MutationMapping
    public boolean deleteBankAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @MutationMapping
    public BankAccount updateBankAccount(@Argument String id, @Argument BankAccountInput input) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));
        bankAccount.setCurrency(input.currency());
        bankAccount.setType(input.type());
        bankAccount.setBalance(input.balance());
        return bankAccountRepository.save(bankAccount);
    }


    record BankAccountInput(AccountType type, double balance, String currency) {
    }

}
