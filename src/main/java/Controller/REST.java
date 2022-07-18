package Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class REST {

    @RequestMapping("/")
    public String home() {
        return "/home";
    }




}
