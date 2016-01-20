package nl.trifork.tictactoe.logic;

import nl.trifork.tictactoe.model.Game;
import nl.trifork.tictactoe.model.GameStatus;
import nl.trifork.tictactoe.model.Position;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author plaarakkers
 */
@RestController
@RequestMapping("/rest")
public class RestLogicController {

    private Game game;
    private GameStatus status;

    public RestLogicController() {
        game = new Game();
        status = GameStatus.PLAYING;
    }

    @RequestMapping(value = "/executeTurn", method = RequestMethod.POST)
    public String move(@RequestParam boolean turn,@RequestParam int column, @RequestParam int row) {

        //boolean computer = !turn;
        Position position = new Position(row, column);

        status = game.addMovement(position, turn);
        //String rowColumnComputer = game.addComputerovement(computer);


        return status.getStatus();

    }

    @RequestMapping(value = "/restart", method = RequestMethod.GET)
    public void resetGame() {
        game.restart();
    }

}
