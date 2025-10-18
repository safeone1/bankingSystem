
package com.example.bank_account_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = BankAccount.class)
public interface AccountProjection {

    public String getId();
    public double getBalance();
    public String getCurrency();
    public String getType();
}
