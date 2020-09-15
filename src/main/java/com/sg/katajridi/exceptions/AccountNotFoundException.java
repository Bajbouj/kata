package com.sg.katajridi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Data
public class AccountNotFoundException extends  RuntimeException{
    private String message;

}
