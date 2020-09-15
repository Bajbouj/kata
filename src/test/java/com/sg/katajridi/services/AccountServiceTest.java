package com.sg.katajridi.services;

import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.Client;
import com.sg.katajridi.repositories.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static com.sg.katajridi.models.OperationType.DEPOSIT;
import static com.sg.katajridi.models.OperationType.WITHDRAWL;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    public void init() {

    }

    @Test
    public void get_account_by_number() {
       Client client = Client.builder().firstName("sam").lastName("sam").build();
       Account accountTest = Account.builder()
                .number("252624")
                .amount(1500)
                .client(client)
                .build();
        accountService.save(accountTest);
        Account result = accountService.findByNumber("252624");
        Assertions.assertAll("get account by number",
                () -> Assertions.assertNotNull(result),
                () -> Assertions.assertSame(accountTest,result)
        );


    }

    @Disabled
    @Test
    public void make_deposit_case() {
        Client client = Client.builder().id(1L).firstName("med").lastName("jridi").build();
        Account account = Account.builder()
                .id(1L)
                .number("343536")
                .client(client)
                .amount(5000)
                .build();
        Account updatedAccount = Account.builder()
                .id(1L)
                .number("343536")
                .client(client)
                .amount(6000)
                .build();

        when((accountRepository).findByNumber("343536")).thenReturn(account);
        when((accountRepository).save(updatedAccount)).thenReturn(updatedAccount);

        Account result = accountService.updateAccountAmount("343536", 1000, DEPOSIT);

        Assertions.assertEquals(result, updatedAccount);
    }

    @Test
    @Disabled
    public void make_withdrawl_case() {
        Client client = Client.builder().id(1L).firstName("med").lastName("jridi").build();
        Account account = Account.builder()
                .id(1L)
                .number("343536")
                .client(client)
                .amount(5000)
                .build();
        Account updatedAccount = Account.builder()
                .id(1L)
                .number("343536")
                .client(client)
                .amount(4000)
                .build();

        when((accountRepository).findByNumber("343536")).thenReturn(account);
        when((accountRepository).save(updatedAccount)).thenReturn(updatedAccount);

        Account result = accountService.updateAccountAmount("343536", 1000, WITHDRAWL);

        Assertions.assertEquals(result, updatedAccount);
    }


}
