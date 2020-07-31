package zijinfeihong.bbs.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
    @PostMapping("/check")
    public String check(){
        return "it works!";
    }
}
