package zijinfeihong.bbs.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CheckController {
    @GetMapping("/check")
    public String check(){
        return "it works!";
    }
}
