package zijinfeihong.bbs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zijinfeihong.bbs.demo.entity.Users;

import java.util.List;

@RestController
public class CheckController {



    @PostMapping("/check")
    public String check(){
        return "it works!";
    }


}
