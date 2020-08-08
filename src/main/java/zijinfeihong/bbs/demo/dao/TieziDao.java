package zijinfeihong.bbs.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zijinfeihong.bbs.demo.entity.Tiezi;

import java.util.List;

/**
 * @author sherman
 * @create 2020--08--06 13:25
 */

@Mapper
@Repository
public interface TieziDao {
    List<Tiezi>queryTieziList();
    Tiezi queryTieziById(int id);
    int addTiezi(Tiezi tiezi);
    int deleteTiezi(int id);
    int updateTiezi(Tiezi tiezi);

}
