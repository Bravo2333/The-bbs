package zijinfeihong.bbs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zijinfeihong.bbs.demo.entity.Users;
import zijinfeihong.bbs.demo.service.LoginService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody Users requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        session.setAttribute("statu","online");
        if(loginService.userlogin(requestUser))
        return  "登陆成功";
        return "登陆失败";
}}

