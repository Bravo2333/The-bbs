package zijinfeihong.bbs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zijinfeihong.bbs.demo.entity.Tiezi;
import zijinfeihong.bbs.demo.service.TieziService;

import java.util.List;

/**
 * @author sherman
 * @create 2020--08--06 15:43
 */

@RestController
public class TieziController {
    @Autowired
    TieziService tieziService;

    @PostMapping("/add")
    public String add(String username,String author,String content){
        tieziService.addTiezi(author,content);
        return "add";
    }

    @PostMapping("/remark")
    public String remark(String username,String author,String content,int tid){
        tieziService.remark(author,content,tid);
        return "remark";
    }

    @PostMapping("/reply")
    public String reply(String username,String author,String content,int rid, int isThird){
        tieziService.reply(author, content, rid,isThird);
        return "reply";
    }

    @PostMapping("/recommend")
    public List<Tiezi> recommend(String username){
        List<Tiezi> tests = tieziService.recommend();
        return tests;
    }

    @PostMapping("/delete")
    public String delete(String username,int id,int sign){
        tieziService.delete(id,sign);
        return "delete";
    }

    @PostMapping("/like")
    public String like(String username,int id,int sign){
        tieziService.like(id,sign);
        return "like";
    }


}
