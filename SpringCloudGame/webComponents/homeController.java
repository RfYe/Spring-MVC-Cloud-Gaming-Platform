package gamesRenting.webComponents;

import gamesRenting.persistence.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class homeController {
    @RequestMapping(value = "/",method=GET)
    public String homePage(){
        return "home";
    }
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String showUserLoginPage(Principal principal){
        if(principal==null)
            return "login";
        return "redirect:/";
    }
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String showUserRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
}
