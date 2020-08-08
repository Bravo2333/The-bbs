package zijinfeihong.bbs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zijinfeihong.bbs.demo.dao.RemarkDao;
import zijinfeihong.bbs.demo.dao.ReplyDao;
import zijinfeihong.bbs.demo.dao.TieziDao;
import zijinfeihong.bbs.demo.entity.Remark;
import zijinfeihong.bbs.demo.entity.Reply;
import zijinfeihong.bbs.demo.entity.Tiezi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sherman
 * @create 2020--08--06 15:47
 */

@Service
public class TieziService {

    @Autowired
    TieziDao tieziDao;

    @Autowired
    RemarkDao remarkDao;

    @Autowired
    ReplyDao replyDao;

    public void addTiezi(String author,String content){
        Date d=new Date();
        Tiezi tiezi = new Tiezi(author,content,d);
        tieziDao.addTiezi(tiezi);
    }

    public void remark(String author,String content,int tid){
        Date d=new Date();
        Remark remark=new Remark(author,d,content,tid);
        remarkDao.addRemark(remark);
    }

    public void reply(String author,String content,int rid,int isThird){
        Date d=new Date();
        Reply reply = new Reply(author,d,content,rid,isThird);
        replyDao.addReply(reply);
    }

    public List<Tiezi> recommend(){
        List<Tiezi>tiezis = tieziDao.queryTieziList();
        List<Tiezi>resultTiezis = new ArrayList<>();
        List<Remark>resultRemarks = new ArrayList<>();
        for(Tiezi tiezi:tiezis){
            List<Remark> remarks = remarkDao.queryRemarkByTid(tiezi.getId());
            for(Remark remark:remarks){
                List<Reply> replies = replyDao.queryReplyByRid(remark.getId());
                resultRemarks.add(new Remark(remark.getId(),remark.getAuthor(), remark.getTime(),
                        remark.getLike(),remark.getContent(),
                        remark.getTid(), new ArrayList<>(replies)));
            }
            resultTiezis.add(new Tiezi(tiezi.getId(),tiezi.getAuthor(),tiezi.getTime(),
                    tiezi.getLike(),tiezi.getContent(),new ArrayList<>(resultRemarks)));
            resultRemarks.clear();
        }
        return resultTiezis;
    }

    public void delete(int id,int sign){
        if(sign==1){
            deleteTiezi(id);
            tieziDao.deleteTiezi(id);
        }
        else if(sign==2){
            deleteRemark(id);
            remarkDao.deleteRemark(id);
        }
        else if(sign==3){
            replyDao.deleteReply(id);
        }
    }

    public void deleteRemark(int id){
        List<Reply> replies = replyDao.queryReplyByRid(id);
        for(Reply reply:replies){
            replyDao.deleteReply(reply.getId());
        }
    }

    public void deleteTiezi(int id){
        List<Remark> remarks = remarkDao.queryRemarkByTid(id);
        for(Remark remark:remarks){
            deleteRemark(remark.getId());
            remarkDao.deleteRemark(remark.getId());
        }
    }

    public void like(int id,int sign){
        if(sign==1){
            Tiezi tiezi = tieziDao.queryTieziById(id);
            int like=tiezi.getLike();
            like++;
            tiezi.setLike(like);
            tieziDao.updateTiezi(tiezi);
        }
        else if(sign==2){
            Remark remark = remarkDao.queryRemarkById(id);
            int like=remark.getLike();
            like++;
            remark.setLike(like);
            remarkDao.updateRemark(remark);
        }
        else if(sign==3){
            Reply reply = replyDao.queryReplyById(id);
            int like=reply.getLike();
            like++;
            reply.setLike(like);
            replyDao.updateReply(reply);
        }
    }


}
