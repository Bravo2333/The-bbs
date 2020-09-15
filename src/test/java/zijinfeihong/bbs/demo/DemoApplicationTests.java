package zijinfeihong.bbs.demo;

import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import zijinfeihong.bbs.demo.dao.UserDao;
import zijinfeihong.bbs.demo.entity.Users;
import zijinfeihong.bbs.demo.service.EmailService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

@Slf4j
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    EmailService emailService;
    @Autowired
    private RedisTemplate<String,  String> redisTemplate;
    @Autowired
    UserDao userDao;
    @Test
    void contextLoads3(){
        Users users=userDao.userChecker("lzx2");
        log.error(users.getPassword());
    }


}
