package nl.trifork.tictactoe.logic;

import nl.trifork.tictactoe.model.Game;
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

    private Game game = new Game();

    @RequestMapping(value = "/executeTurn", method = RequestMethod.POST)
    public String move(@RequestParam boolean turn,@RequestParam int column, @RequestParam int row) {

        Position position = new Position(row, column);

        game.addMovement(position, turn);

        return String.format("Turn executed for player '%b', on column '%d' and row '%d'", turn, column, row);
    }
}
