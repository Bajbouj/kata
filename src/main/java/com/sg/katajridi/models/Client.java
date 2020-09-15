package com.sg.katajridi.models;

import com.sg.katajridi.models.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Client {
    @Id
    @GeneratedValue
    private final Long id;
    private final String firstName;
    private final String lastName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Account account;

}
