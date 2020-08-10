package zijinfeihong.bbs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zijinfeihong.bbs.demo.dao.UserDao;
import zijinfeihong.bbs.demo.entity.Users;

/**
 * @author sherman
 * @create 2020--08--08 9:23
 */

@Service
public class FileService {

    @Autowired
    UserDao userDao;
    public void headUpload(String username,String path){
        Users user = userDao.userChecker(username);
        user.setHeadpath(path);
        userDao.updateHeadPath(user);
    }
}

