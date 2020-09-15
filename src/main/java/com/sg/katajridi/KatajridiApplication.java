package com.sg.katajridi;

import com.sg.katajridi.models.Account;
import com.sg.katajridi.models.Client;
import com.sg.katajridi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KatajridiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KatajridiApplication.class, args);
    }

}
