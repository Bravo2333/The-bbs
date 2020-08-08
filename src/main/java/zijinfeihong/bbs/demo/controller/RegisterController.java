package zijinfeihong.bbs.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import zijinfeihong.bbs.demo.service.RegisterService;

import javax.servlet.http.HttpSession;

import static javax.swing.text.html.HTML.Tag.S;

public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/register")
    public String register(@Param("Username") String username,
                           @Param("password") String password,
                           @Param("email") String email,
                           @Param("identification") String identification, HttpSession hs) {
        Object object = hs.getAttribute("registerCode");
        if (object == null) {
            return "验证码为空";
        }
        int retrieveCode = (Integer) object;
        String code = String.valueOf(retrieveCode);
        if (identification.equals(code)) {
            hs.removeAttribute("registerCode");
            return null;
        } else
            return "验证码错误";


    }

}
