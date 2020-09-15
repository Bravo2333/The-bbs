package zijinfeihong.bbs.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zijinfeihong.bbs.demo.entity.Users;
import zijinfeihong.bbs.demo.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @PostMapping(value = "/login")
    public int login(@RequestParam("username")String username,
                     @RequestParam("password")String password){
        log.error(username);
        log.error(password);
        Users requestUser=new Users("",username,password,"");
        log.error(requestUser.toString());
        if(loginService.userlogin(requestUser)){
            redisTemplate.opsForValue().set(username,"logged",30, TimeUnit.MINUTES);
        return  200;}
        return  404;
}}

