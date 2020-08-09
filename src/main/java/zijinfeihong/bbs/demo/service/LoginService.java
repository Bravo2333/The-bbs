package zijinfeihong.bbs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import zijinfeihong.bbs.demo.dao.UserDao;
import zijinfeihong.bbs.demo.entity.Users;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;
    public boolean userlogin(@RequestBody Users requestUser){
        Users users=userDao.userChecker(requestUser.getUsername());

        return (users.getPassword()==requestUser.getPassword());
    }
}
