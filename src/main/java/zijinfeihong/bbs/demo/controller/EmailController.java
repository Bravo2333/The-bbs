package zijinfeihong.bbs.demo.controller;

import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zijinfeihong.bbs.demo.service.EmailService;

import javax.servlet.http.HttpSession;

/**
 * @author sherman
 * @create 2020--08--02 23:51
 */

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sendIdentification")
    public String sendIdentification(String username, String email, int sign,HttpSession session) throws MessagingException, javax.mail.MessagingException {
        if(username!=null&&email!=null){
            if(sign==1){
                int number1=emailService.sendEmail(username,email,"注册时的验证码","邮箱验证");
                session.setAttribute("registerCode",number1);
            }
            if(sign==2){
                int number2=emailService.sendEmail(username,email,"找回密码时的验证码","找回密码");
                session.setAttribute("retrieveCode",number2);
            }
        }
        return "sendIdentification";
    }


    @PostMapping("/Retrieve")
    public String retrieveValidation(int RetrieveCode, Model model,HttpSession session){
        Object object=session.getAttribute("retrieveCode");
        int retrieveCode=(int)object;
        if(RetrieveCode==retrieveCode){
            model.addAttribute("msg","成功");
            return "可以的";
        }
        else{
            model.addAttribute("msg","失败");
            return "西八";
        }


    }


}
