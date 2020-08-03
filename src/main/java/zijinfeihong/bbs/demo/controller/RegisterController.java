package zijinfeihong.bbs.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

public class RegisterController {
        @PostMapping("/register")
        public String register(@Param("Username")String username,
                               @Param("account")String account,
                               @Param("password")String password,
                               @Param("email")String email,
                               @Param("identification")String identification){

            return "注册成功";
        }

}
