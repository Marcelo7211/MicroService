package com.communication.bank.exceptions;

public class PaymentException extends RuntimeException {
	
	private static final long serialVersionUID = 8011193673466440726L;

	public PaymentException(String message) {
        super(message);
    }

}
