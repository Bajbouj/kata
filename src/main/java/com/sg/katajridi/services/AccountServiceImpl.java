package com.sg.katajridi.services;

import com.sg.katajridi.exceptions.AccountNotFoundException;
import com.sg.katajridi.exceptions.InsufficientBalanceException;
import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.OperationType;
import com.sg.katajridi.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.sg.katajridi.models.OperationType.DEPOSIT;
import static com.sg.katajridi.models.OperationType.WITHDRAWL;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public Account findByNumber(String number) {

        return accountRepository.findByNumber(number);
    }
    private Optional<Account> fetchByNumero(String accountNumero) {
        return Optional.of(accountRepository.findByNumber(accountNumero));
    }
    @Override
    public Account updateAccountAmount(String accountNumber, double amountNeeded, OperationType operationType) {
        Account account = fetchByNumero(accountNumber)
                .orElseThrow(() ->  AccountNotFoundException.builder().message("Account Not Found, please check your account number.").build());

            switch (operationType) {
                case DEPOSIT:
                    return accountRepository.save(Account.builder().id(account.getId())
                            .number(account.getNumber())
                            .client(account.getClient())
                            .amount(account.getAmount() + amountNeeded)
                            .build());
                case WITHDRAWL:
                    if (amountNeeded > account.getAmount()) {
                        throw InsufficientBalanceException.builder().message("Insufficient Account Provision.").build();
                    }
                    return accountRepository.save(Account.builder().id(account.getId())
                            .number(account.getNumber())
                            .client(account.getClient())
                            .amount(account.getAmount() - amountNeeded)
                            .build());
                default:
                    throw new IllegalArgumentException("Please verify your operation type");

            }

    }


}
