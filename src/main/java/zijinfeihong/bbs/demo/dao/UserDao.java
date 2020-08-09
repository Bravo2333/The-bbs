package zijinfeihong.bbs.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import zijinfeihong.bbs.demo.entity.Tiezi;
import zijinfeihong.bbs.demo.entity.Users;

@Mapper
@Repository
public interface UserDao {
//    @Select("Select * from user where username=#{username}")
//    Users userChecker(String username);
//    @Insert("insert into user (email,username,password,headpath) values(#{email},#{username},#{password},#{headpath})")
//    Boolean userRegister(Users user);
//    @Update("update user set user.headpath = #{headpath} where user.username = #{username}")
//    int userHeadpathUpdate(Users users);
    int updateHeadPath(Users users);
    Users queryUserByName(String username);
}
