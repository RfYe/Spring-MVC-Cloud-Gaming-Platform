package gamesRenting.webComponents;

import gamesRenting.persistence.Game;
import gamesRenting.persistence.gamesRepository;
import gamesRenting.persistence.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class gamesController {
    private usersRepository ur;
    private gamesRepository gr;
    @Autowired
    public gamesController(gamesRepository gr,usersRepository ur){
        this.gr=gr;this.ur=ur;
    }
    @RequestMapping(value="/games",method=RequestMethod.GET)
    public String showAllGames(Model model,HttpServletRequest request){
        Object userId=request.getSession().getAttribute("id");
        if(userId!=null){
            List<Game> userGames=ur.getUserLibraryById((Integer) userId);
            List<Integer> userGameListId=new ArrayList<>();
            for(Game g:userGames){
                userGameListId.add(g.getId());
            }
            model.addAttribute("userGameListId",userGameListId);
        }
        List<Game> gameList=gr.findAllGames();
        model.addAttribute("gamelist",gameList);
        return "allGames";
    }
    @RequestMapping(value="/addGame",method=RequestMethod.GET)
    public String showAddGameForm(Model model){
        model.addAttribute("game",new Game());
        return "newGame";
    }
    @RequestMapping(value="/addGame",method=RequestMethod.POST)
    public String addNewGame(Game newGame){
        gr.addGame(newGame);
        return "home";
    }
    @RequestMapping(value="/games/{gameId}",method = RequestMethod.GET)
    public String getGameProfile(@PathVariable("gameId") int gameId,Model model){
        model.addAttribute("game",gr.getGameById(gameId));
        return "gameProfile";
    }
}
