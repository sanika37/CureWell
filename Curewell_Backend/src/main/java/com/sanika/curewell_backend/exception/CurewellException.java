package com.sanika.curewell_backend.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
@EqualsAndHashCode(callSuper = true)
@Data
public class CurewellException extends RuntimeException{
    private HttpStatus status;
    private String message;
    public CurewellException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}