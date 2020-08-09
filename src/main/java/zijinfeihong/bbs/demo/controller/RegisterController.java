package zijinfeihong.bbs.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zijinfeihong.bbs.demo.service.EmailService;
import zijinfeihong.bbs.demo.service.RegisterService;

import javax.servlet.http.HttpSession;


@RestController
public class RegisterController {

        @PostMapping("/register")
        public String register(@Param("Username")String username,
                               @Param("password")String password,
                               @Param("email")String email,
                               @Param("identification")String identification,
                               HttpSession session){
            Object object=session.getAttribute("registerCode");
            if(object==null){
                return "验证码发送错误！";
            }
            int retrieveCode=(Integer) object;
            String code=String.valueOf(retrieveCode);
            if(identification.equals(code)){
                session.removeAttribute("registerCode");
                return "验证码正确，注册成功。";
            }
            else return "验证码错误，注册失败。";

    }

}
