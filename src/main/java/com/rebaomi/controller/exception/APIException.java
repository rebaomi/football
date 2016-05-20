package com.rebaomi.controller.exception;

@SuppressWarnings("serial")
public class APIException extends FException{
    
    public APIException() {
    }
    
    public APIException(ETfExceptionMsg EMsg) {
        super(EMsg.getMsg());
    }

    public APIException(ETfExceptionMsg EMsg, Throwable ex) {
        super(EMsg.getMsg(), ex);
    }
    
    public APIException(String msg) {
        super(msg);
    }

    public APIException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
