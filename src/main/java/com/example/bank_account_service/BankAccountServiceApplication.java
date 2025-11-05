package com.example.bank_account_service;

import java.util.Date;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.entities.Customer;
import com.example.bank_account_service.enums.AccountType;
import com.example.bank_account_service.repositories.BankAccountRepository;
import com.example.bank_account_service.repositories.CustomerRepository;

@SpringBootApplication
public class BankAccountServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
		return args -> {

			for (int i = 0; i <= 50; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > .5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
						.balance(Math.random() * 90000)
						.createdAt(new Date().toString())
						.currency("MAD")
						.updatedAt(new Date().toString())
						.build();
				bankAccountRepository.save(bankAccount);
			}
			
			for (int i = 0; i <= 50; i++) {
				Customer customer = Customer.builder()
						.id(UUID.randomUUID().toString())
						.firstName("FirstName" + i)
						.lastName("LastName" + i)
						.email("customer" + i + "@example.com")
						.phoneNumber("123-456-7890")
						.address("123 Main St, City " + i)
						.createdAt(new Date().toString())
						.updatedAt(new Date().toString())
						.build();
				customerRepository.save(customer);
			}
		};
	}
	}



