package com.sg.katajridi.repositories;

import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository <Operation,Long> {

    List<Operation> findAllByAccount(Account account);

}
