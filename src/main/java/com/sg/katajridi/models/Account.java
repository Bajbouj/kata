package com.sg.katajridi.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Account {
    @Id
    @GeneratedValue
    private final Long id;

    @NonNull
    private final String number;

    private final double amount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Client client;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<Operation> operations;
}
