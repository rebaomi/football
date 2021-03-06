package com.rebaomi.football.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rebaomi.model.FUser;
import com.rebaomi.util.ServiceResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "user-api", description = "异步数据API调试", position = 5)  
@Controller
@RequestMapping(value = "/swagger", produces = { "text/html;charset=UTF-8" })
public class SwaggerTestController {
    
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value="添加用户",httpMethod="GET",response=ServiceResult.class,notes="add user")
    public @ResponseBody String testSwagger(@ApiParam(required=true,name="postData",value="用户信息json数据") @RequestParam(value="postData")String postData) {
        
        return JSON.toJSONString(new ServiceResult().success());
    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value="添加用户",httpMethod="POST",response=ServiceResult.class,notes="add user")
    public @ResponseBody String testSwaggerUser(@ApiParam(required=true,name="user",value="用户信息json数据{username:'',phone:''}") @RequestBody FUser user) {
        
        return JSON.toJSONString(new ServiceResult().success());
    }
    
}