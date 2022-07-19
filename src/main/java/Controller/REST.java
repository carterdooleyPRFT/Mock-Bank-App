package Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class REST {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/createaccount")
    public String createAccount() {
        return "createaccount";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }






}
