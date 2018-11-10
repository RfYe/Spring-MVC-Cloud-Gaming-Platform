package gamesRenting.webComponents;

import gamesRenting.persistence.Game;
import gamesRenting.persistence.User;
import gamesRenting.persistence.gamesRepository;
import gamesRenting.persistence.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
@Controller
public class usersController {
    private usersRepository ur;
    private gamesRepository gr;
    @Autowired
    public usersController(usersRepository ur,gamesRepository gr){
        this.ur=ur;this.gr=gr;
    }
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String processRegistration(@Valid User user, BindingResult errors, Model model){
       if(errors.hasErrors()){
           model.addAttribute("user",user);
           return "register";
       }
       if(ur.getUserIdByUserName(user.userName)!=-1){
           FieldError fe=new FieldError("user","userName","An account already exists for this username.");
           errors.addError(fe);
           return "register";
       }
        ur.addUser(user);
        return "redirect:/login";
    }
//    @RequestMapping(value="/profile/{userId}",method = RequestMethod.GET)
//    public String getUserProfile(@PathVariable("userId") int userId,Model model){
//        model.addAttribute("user",ur.getUserById(userId));
//        return "userProfile";
//    }
    @RequestMapping(value="/mylibrary",method=RequestMethod.GET)
    public String getUserLibrary(HttpServletRequest request,Model model){
       int id=(Integer)request.getSession().getAttribute("id");
        List<Game> gameList=ur.getUserLibraryById(id);
        model.addAttribute("gamelist",gameList);
       return "mylibrary";
    }

    @RequestMapping(value="/addtolibrary/{gameId}",method=RequestMethod.GET)
    public String addToUserLibrary(@PathVariable("gameId") int gameId,HttpServletRequest request){
        int userId=(Integer)request.getSession().getAttribute("id");
        Game game=gr.getGameById(gameId);
        User currentUser=ur.getUserById(userId);
        List<Game> currentLibrary=currentUser.gameLibrary;
        for(Game g:currentLibrary){
            if(g.getId()==gameId) {
                System.out.println("You've already owned this game");
                return "redirect:/mylibrary";
            }
        }
        currentLibrary.add(game);
        ur.updateUser(currentUser);
        return "redirect:/mylibrary";
    }
}
