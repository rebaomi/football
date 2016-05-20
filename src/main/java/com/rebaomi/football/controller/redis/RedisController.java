package com.rebaomi.football.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class RedisController {
    
    @Autowired
    private MyRepository myUserRepo;
    
    
    // http://snowolf.iteye.com/blog/1666908
    
    
    @RequestMapping(value="/redis/test", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> test() throws Exception{
        MyUser user = new MyUser("zhaoxing",12);
        String key = "my:user:zhaoxing";
        myUserRepo.set(key, user);
        MyUser me = myUserRepo.get(key);
        System.out.println(JSON.toJSONString(me));
        return new ResponseEntity<>(JSON.toJSONString(me),HttpStatus.OK);
    }
    
}
