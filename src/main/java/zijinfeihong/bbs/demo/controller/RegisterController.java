package zijinfeihong.bbs.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class RegisterController {

        @PostMapping("/register")
        public String register(@Param("Username")String username,
                               @Param("account")String account,
                               @Param("password")String password,
                               @Param("email")String email,
                               @Param("identification")String identification,
                               HttpSession session){
            Object object=session.getAttribute("registerCode");
            if(object==null){
                return "session为空";
            }
            int retrieveCode=(Integer) object;
            String code=String.valueOf(retrieveCode);
            if(identification.equals(code)){
                session.removeAttribute("registerCode");
                return "验证码正确";
            }
            else return "验证码错误";

    }

}
