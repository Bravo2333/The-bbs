package zijinfeihong.bbs.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import zijinfeihong.bbs.demo.dao.UserDao;
import zijinfeihong.bbs.demo.service.EmailService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


/**
 * @author sherman
 * @create 2020--08--02 23:51
 */
@Slf4j
@RestController
public class EmailController {
    @Autowired
    UserDao userDao;
    @Autowired
    EmailService emailService;
    @Autowired
    private RedisTemplate<String,  String> redisTemplate;

    @PostMapping("/sendIdentification")
    public String sendIdentification( String username, String email, HttpSession session) throws MessagingException {
        log.error(email);
        log.error(username);
        if(username!=null&&email!=null){
                int number1=emailService.sendEmail(username,email,"注册时的验证码","邮箱验证");
                String s=Integer.toString(number1);
                redisTemplate.opsForValue().set(email,s,30,TimeUnit.SECONDS);
        }
        return "sendIdentification";
    }
    @PostMapping("/sendIdentification/retrieve")
    public String sendIdentificationre(String username, String email, HttpSession session)throws MessagingException {
        if(username!=null&&email!=null){

                int number2=emailService.sendEmail(username,email,"找回密码时的验证码","找回密码");
                session.setAttribute("retrieveCode",number2);}
            return "找回密码的验证码接口";
        }
    @PostMapping("/retrieve")
    public int retrieveValidation(String username,@Param("identification")String identification,String email, String newpassword){
        if(email==null){
            return 411;
        }
        String str=redisTemplate.opsForValue().get(email);

        if(identification.equals(str)){
            userDao.updatePassword(newpassword,username);
            return 200;//dao层的
        }
        else return 404;


    }


}
