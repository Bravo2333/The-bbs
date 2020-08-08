package zijinfeihong.bbs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zijinfeihong.bbs.demo.Dao.UserDao;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;


}
