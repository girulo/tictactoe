package nl.trifork.tictactoe.logic;

import com.google.gson.Gson;
import nl.trifork.tictactoe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author plaarakkers
 */
@RestController
@RequestMapping("/rest")

public class RestLogicController {

    private final Game game;
    private MoveResults moveResults;

    @Autowired
    public RestLogicController(Game game) {
        this.game = game;
        this.moveResults = new MoveResults();
    }

    @RequestMapping()
    public int start(HttpServletRequest request) {

        String playerName = (String)request.getSession().getAttribute("player");

        if (game.newPlayer(playerName)) {
            game.addPlayer(playerName);
        }
        int maxScore = game.start(playerName);
        return maxScore;
    }

    @RequestMapping(value = "/executeTurn", method = RequestMethod.POST)
    public String move(@RequestParam boolean turn, @RequestParam int column, @RequestParam int row) {

        //boolean computer = !turn;
        Position position = new Position(row, column);

        moveResults = game.addMovement(position, turn);
        //String rowColumnComputer = game.addComputerovement(computer);

        Gson gson = new Gson();

        return gson.toJson(moveResults);

    }

    @RequestMapping(value = "/restart", method = RequestMethod.GET)
    public void resetGame() {
        game.restart();
    }

}
