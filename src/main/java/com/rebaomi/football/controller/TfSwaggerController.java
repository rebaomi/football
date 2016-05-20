package com.rebaomi.football.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rebaomi.util.ServiceResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @desc  一些静态页面路由
 * @author chenqm
 * @date 2015年11月13日
 */
@Api(value = "user-api", description = "淘房点点异步数据API调试", position = 5)  
@Controller
public class TfSwaggerController {
    @RequestMapping("test")
    @ApiOperation(value="同步测试",httpMethod="GET",response=ServiceResult.class,notes="add user")
    public String swagger(){
        return "swagger/index";
    }
}
