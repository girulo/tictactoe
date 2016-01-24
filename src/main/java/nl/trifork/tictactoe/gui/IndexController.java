package nl.trifork.tictactoe.gui;

import nl.trifork.tictactoe.model.Game;
import nl.trifork.tictactoe.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author plaarakkers
 */
@Controller
@RequestMapping("/")
@ComponentScan
public class IndexController {

    private final Game game;

    @Autowired
    public IndexController(Game game) {
        this.game = game;
    }

    @RequestMapping
    public String index(Model model) {

        model.addAttribute("player", new Player());
        return "index";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String startGame(HttpServletRequest request, @ModelAttribute("player") Player player, Model model) {

        request.getSession().setAttribute("player", player.getName());
        return "tictactoe";
    }

    @RequestMapping(value = "/showscores")
    public String showScores(Model model) {

        Map<String, String> countryCapitalList = new HashMap<String, String>();
        countryCapitalList.put("United States", "Washington DC");
        countryCapitalList.put("India", "Delhi");
        countryCapitalList.put("Germany", "Berlin");
        countryCapitalList.put("France", "Paris");
        countryCapitalList.put("Italy", "Rome");

        model.addAttribute("capitalList", countryCapitalList);

        model.addAttribute("scoreList", game.getScoreList());

        return "scores";
    }

}
