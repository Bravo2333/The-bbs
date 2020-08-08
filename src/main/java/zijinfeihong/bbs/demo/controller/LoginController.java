package zijinfeihong.bbs.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zijinfeihong.bbs.demo.entity.Users;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public String login(@RequestBody Users requestUser, HttpSession session) {
        String username = requestUser.getUsername();
    return  null;
}}

