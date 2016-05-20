package com.rebaomi.controller.exception;

@SuppressWarnings("serial")
public class PageException extends FException{
    
    public PageException() {
    }
    
    public PageException(ETfExceptionMsg EMsg) {
        super(EMsg.getMsg());
    }

    public PageException(ETfExceptionMsg EMsg, Throwable ex) {
        super(EMsg.getMsg(), ex);
    }
    
    public PageException(String msg) {
        super(msg);
    }

    public PageException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
