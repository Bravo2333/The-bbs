package zijinfeihong.bbs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * @author sherman
 * @create 2020--08--03 0:06
 */

@Service
public class EmailService {

    @Autowired
    JavaMailSenderImpl mailSender;
    private int random;

    public void sendEmail(String username, String email, String sentence, String subject) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        int randomNum= (int)(Math.random()*10000);
        if(randomNum<1000){
            randomNum+=1000;
        }
        random=randomNum;
        helper.setSubject(subject);
        helper.setText("你好，"+username+'。'+sentence+randomNum);
        helper.setTo(email);
        helper.setFrom("2218785142@qq.com");
        mailSender.send(mimeMessage);

    }

    public int getRandom() {
        return random;
    }
}
