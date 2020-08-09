package zijinfeihong.bbs.demo.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zijinfeihong.bbs.demo.dao.UserDao;
import zijinfeihong.bbs.demo.entity.Users;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;
    public  void registerService(String username,String password,String email){
        Users users=new Users(email,username,password,"");
        userDao.userRegister(users);
    }

}
