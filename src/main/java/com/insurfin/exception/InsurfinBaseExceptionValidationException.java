package com.insurfin.exception;

public class InsurfinBaseExceptionValidationException extends InsurfinBaseException{

    private static final long serialVersionUID = 1L;

    public InsurfinBaseExceptionValidationException(String exceptionKey, Object data, final Object...args) {
        super(exceptionKey, data, args);
    }
}
