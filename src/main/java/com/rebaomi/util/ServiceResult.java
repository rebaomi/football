package com.rebaomi.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.common.collect.Maps;
import com.rebaomi.common.EServiceResultCode;

public class ServiceResult {

    private boolean success;
    private String msg;
    private Integer resultCode ;
    
    private Map<String, Object> resultMap = Maps.newHashMap();
    private Object data;
    
    public ServiceResult(boolean key,Object data){
        this.success = key;
        this.data = data;
    }
    
    public ServiceResult(boolean key,String msg){
        this.success = key;
        this.msg = msg;
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 失败
     */
    public ServiceResult failed() {
        this.resultCode = EServiceResultCode.DEFAULT_ERROR.getCode();
        this.success = false;
        return this;
    }

    /**
     * 失败
     * 
     * @param msg
     */
    public ServiceResult failed(String msg) {
        this.success = false;
        this.msg = msg;
        this.resultCode = EServiceResultCode.DEFAULT_ERROR.getCode();
        return this;
    }

    /**
     * 成功
     */
    public ServiceResult success() {
        this.resultCode = EServiceResultCode.DEFAULT_SUCCESS.getCode();
        this.success = true;
        return this;
    }

    /**
     * 成功
     * 
     * @param msg
     */
    public ServiceResult success(String msg) {
        this.resultCode = EServiceResultCode.DEFAULT_SUCCESS.getCode();
        this.success = true;
        this.msg = msg;
        return this;
    }

    /**
     * 成功
     * 
     * @param resultMap
     */
    public ServiceResult success(Map<String, Object> resultMap) {
        this.resultCode = EServiceResultCode.DEFAULT_SUCCESS.getCode();
        this.success = true;
        this.resultMap = resultMap;
        return this;
    }

    /**
     * 成功
     * 
     * @param msg
     * @param resultMap
     */
    public ServiceResult success(String msg, Map<String, Object> resultMap) {
        this.resultCode = EServiceResultCode.DEFAULT_SUCCESS.getCode();
        this.success = true;
        this.msg = msg;
        this.resultMap = resultMap;
        return this;
    }

    public ServiceResult() {
        this.success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }
    
    @Override
    public String toString() {
        ValueFilter filter = new ValueFilter() {
            @Override
            public Object process(Object obj, String s, Object v) {
                if (v == null) {
                    return "";
                }
                return v;
            }
        };
        return JSON.toJSONString(this,filter);
    }
    
}
