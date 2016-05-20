package com.rebaomi.controller.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rebaomi.common.WebConstants;
import com.rebaomi.util.ServiceResult;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public String baseExceptionHandle(FException excep, HttpServletRequest request, HttpServletResponse response) throws IO4APIException{
        excep.printStackTrace();
        String ajax = request.getHeader("X-Requested-With");
        if ( null != ajax && ajax.equals("XMLHttpRequest") ) {
            ServiceResult errorResult = getErrorResult(excep.getMessage());
            
            PrintWriter writer;
            try {
                response.setContentType(WebConstants.DEFAULT_CONTENT_TYPE);
                response.setCharacterEncoding(WebConstants.DEFAULT_CHARSETACTER_ENCODING);
                
                writer = response.getWriter();
                writer.write(JSON.toJSONString(errorResult));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IO4APIException(excep.getMessage(),e);
            }
        }
        
        return "/404";
    }
    

    @ExceptionHandler
    public String pageExceptionHandle(PageException excep){
        excep.printStackTrace();
        return "/404";
    }
    
    @ExceptionHandler
    public @ResponseBody String apiExceptionHandle(APIException excep){
        excep.printStackTrace();
        ServiceResult errorResult = getErrorResult(excep.getMessage());
        
        return JSON.toJSONString(errorResult);
    }
    
    
    @ExceptionHandler
    public @ResponseBody String io4APIExceptionHandle(IO4APIException excep){
        excep.printStackTrace();
        ServiceResult errorResult = getErrorResult(excep.getMessage());
        
        return JSON.toJSONString(errorResult);
    }
    
    private ServiceResult getErrorResult(String msg){
        ServiceResult errorResult = new ServiceResult();
        errorResult.failed(msg);
        
        return errorResult;
    }
}
