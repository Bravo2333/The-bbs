package zijinfeihong.bbs.demo.dao;



import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zijinfeihong.bbs.demo.entity.Remark;

import java.util.List;

/**
 * @author sherman
 * @create 2020--08--06 17:31
 */

@Mapper
@Repository
public interface RemarkDao {
    List<Remark> queryRemarkList();
    Remark queryRemarkById(int id);
    int addRemark(Remark remark);
    int deleteRemark(int id);
    List<Remark> queryRemarkByTid(int tid);
    int updateRemark(Remark remark);
}
