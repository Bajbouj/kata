package com.sg.katajridi.services;

import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.OperationType;

public interface AccountService  {

    Account save(Account account);

    Account findByNumber(String number) ;

    Account updateAccountAmount(String accountNumber, double amountNeeded, OperationType operationType);

}
