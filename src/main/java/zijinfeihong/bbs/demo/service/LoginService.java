package zijinfeihong.bbs.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zijinfeihong.bbs.demo.dao.UserDao;
import zijinfeihong.bbs.demo.entity.Users;
@Slf4j
@Service
public class LoginService {
    @Autowired
    UserDao userDao;
    public boolean userlogin(Users requestUser){
        log.error(requestUser.getUsername());
        log.error(requestUser.getPassword());
        Users users=userDao.userChecker(requestUser.getUsername());
        if(users==null){
            return false;
        }
        return (users.getPassword().equals(requestUser.getPassword()));
    }
}
