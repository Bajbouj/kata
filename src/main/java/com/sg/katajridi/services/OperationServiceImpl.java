package com.sg.katajridi.services;

import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.Operation;
import com.sg.katajridi.repositories.AccountRepository;
import com.sg.katajridi.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Operation> findAllByAccount(String accountNumber) {
        Account account = accountRepository.findByNumber(accountNumber);
        return operationRepository.findAllByAccount(account);
    }
}
