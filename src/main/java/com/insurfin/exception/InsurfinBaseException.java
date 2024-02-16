package com.insurfin.exception;

import com.insurfin.util.ApplicationConstants;
import lombok.Data;

@Data
public class InsurfinBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public transient String exceptionKey;

    public transient Object[] args;

    public transient Object data;

    public InsurfinBaseException() {
        this(ApplicationConstants.DEFAULT_ERROR_MESSAGE,new Object[] {});
    }

    public InsurfinBaseException(String exceptionKey) {
        this(exceptionKey,new Object[] {});
    }


    public InsurfinBaseException(final String exceptionKey,Object data, final Object...  args) {
        super(exceptionKey);
        this.exceptionKey=exceptionKey;
        this.args=args;
        this.data = data;
    }

    public void setExceptionKey(String exceptionKey) {
        this.exceptionKey = exceptionKey;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public void setData(Object data) {
        this.data = data;
    }









}
