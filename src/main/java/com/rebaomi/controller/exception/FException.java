package com.rebaomi.controller.exception;

@SuppressWarnings("serial")
public class FException extends Exception{
    
    public FException() {
    }
    
    public FException(ETfExceptionMsg EMsg) {
        super(EMsg.getMsg());
    }

    public FException(ETfExceptionMsg EMsg, Throwable ex) {
        super(EMsg.getMsg(), ex);
    }
    
    public FException(String msg) {
        super(msg);
    }

    public FException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
