package zijinfeihong.bbs.demo.controller;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zijinfeihong.bbs.demo.service.RegisterService;

import javax.servlet.http.HttpSession;
@Slf4j
@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
        @PostMapping("/register")
        public int register(@Param("Username")String username,
                            @Param("password")String password,
                            @Param("email")String email,
                            @Param("identification")String identification){
            if(email==null||identification==null){
                return 411;//未知邮箱
            }
            String str=redisTemplate.opsForValue().get(email);
            if(identification.equals(str)){
                registerService.registerService(username,password,email);
                return 200;//妥了
            }
            else return 404;            //验证码过期，或者未发送验证码
    }

}
