package com.communication.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.communication.bank.gateway.json.RetornoJson;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RetornoJson process(RuntimeException ex) {
        return new RetornoJson(ex.getMessage());
    }
    
}

