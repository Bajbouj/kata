package com.sg.katajridi.services;

import com.sg.katajridi.models.Operation;

import java.util.List;

public interface OperationService  {

    List <Operation> findAllByAccount(String accountNumber);

}
