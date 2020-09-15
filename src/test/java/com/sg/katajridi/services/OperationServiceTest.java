package com.sg.katajridi.services;

import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.Client;
import com.sg.katajridi.models.Operation;
import com.sg.katajridi.repositories.AccountRepository;
import com.sg.katajridi.repositories.OperationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static com.sg.katajridi.models.OperationType.DEPOSIT;
import static com.sg.katajridi.models.OperationType.WITHDRAWL;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperationServiceTest {
    @Mock
    private OperationRepository operationRepository;
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    @Spy
    private OperationServiceImpl operationService;

    private Operation depot;
    private Operation retrait;
    private Account account;

    @BeforeEach
    public void init() {
        Client client = Client.builder().firstName("med").lastName("jridi").build();
        account = Account.builder()
                .number("787776")
                .amount(3000)
                .client(client)
                .build();
        depot = Operation.builder()
                .amountOperation(2000)
                .date(LocalDateTime.now())
                .account(account)
                .operationType(DEPOSIT)
                .build();
        retrait = Operation.builder()
                .amountOperation(1000)
                .date(LocalDateTime.now())
                .account(account)
                .operationType(WITHDRAWL)
                .build();
    }

    @Test
    public void get_all_operations_by_account() {

        when((accountRepository).findByNumber("787776")).thenReturn(account);
        when((operationRepository).findAllByAccount(account)).thenReturn(of(depot, retrait));

        List<Operation> operations = operationService.findAllByAccount("787776");

        Assertions.assertAll("Get all operations by account",

                () -> Assertions.assertNotNull(operations),
                () -> Assertions.assertEquals(operations.size(), 2),
                () -> Assertions.assertEquals(operations.get(0), depot),
                () -> Assertions.assertEquals(operations.get(1), retrait)
        );

    }
}
