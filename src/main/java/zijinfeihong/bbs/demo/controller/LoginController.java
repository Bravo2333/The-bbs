package zijinfeihong.bbs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zijinfeihong.bbs.demo.entity.Users;
import zijinfeihong.bbs.demo.service.LoginService;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping(value = "/login")
    public String login(@RequestParam ("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session) {

        Users requestUser=new Users("",username,password,"");
        if(loginService.userlogin(requestUser)){
            session.setAttribute("statu","online");
        return  "登陆成功";}
        return "登陆失败";
}}

