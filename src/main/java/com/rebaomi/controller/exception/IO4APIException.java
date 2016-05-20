package com.rebaomi.controller.exception;

@SuppressWarnings("serial")
public class IO4APIException extends APIException{
    
    public IO4APIException() {
    }
    
    public IO4APIException(ETfExceptionMsg EMsg) {
        super(EMsg.getMsg());
    }

    public IO4APIException(ETfExceptionMsg EMsg, Throwable ex) {
        super(EMsg.getMsg(), ex);
    }
    
    public IO4APIException(String msg) {
        super(msg);
    }

    public IO4APIException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
