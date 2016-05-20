package com.rebaomi.controller.exception;

public enum ETfExceptionMsg {
    ERROR_QUERY_NEWS_LIST("查询新闻信息列表失败"),
    COMMENTED_DENY_TO_CANCLE_ACT_RESERVE_ORDER("已评价~不能取消订单"),
    FAIL_TO_CANCLE_ORDER("取消订单失败");
    
    private String msg;
    
    ETfExceptionMsg(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
