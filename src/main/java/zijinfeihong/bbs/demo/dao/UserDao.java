package zijinfeihong.bbs.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zijinfeihong.bbs.demo.entity.Users;

@Mapper
@Repository
public interface UserDao {
    @Select("Select * from user where username=#{username}")
    Users userChecker(String username);
    @Insert("insert into user (email,username,password,headpath) values(#{email},#{username},#{password},#{headpath})")
    Boolean userRegister(Users user);

    int updateHeadPath(Users user);


}
