package com.sg.katajridi.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Operation {
    @Id
    @GeneratedValue
    private final Long id;

    private final LocalDateTime date;

    private final double amountOperation;

    private final OperationType operationType;

    @ManyToOne(fetch = FetchType.LAZY)
    private final Account account;
}
