package zijinfeihong.bbs.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zijinfeihong.bbs.demo.entity.Reply;

import java.util.List;

/**
 * @author sherman
 * @create 2020--08--06 17:31
 */

@Mapper
@Repository
public interface ReplyDao {
    List<Reply> queryReplyList();
    Reply queryReplyById(int id);
    int addReply(Reply reply);
    int deleteReply(int id);
    List<Reply> queryReplyByRid(int rid);
    int updateReply(Reply reply);
}
