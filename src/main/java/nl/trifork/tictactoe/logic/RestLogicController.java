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

    private Game game = new Game();

    @RequestMapping(value = "/executeTurn", method = RequestMethod.POST)
    public String move(@RequestParam boolean turn,@RequestParam int column, @RequestParam int row) {

        boolean computer = !turn;
        Position position = new Position(row, column);

        GameStatus status = game.addMovement(position, turn, computer);

        return String.format("Turn executed for player '%b', on column '%d' and row '%d', game status: '%s", turn, column, row, status.toString());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void String() {
//        game.addMovement(new Position(1,1), true);
//        game.addMovement(new Position(1,2), true);
//        game.addMovement(new Position(2,2), true);
//        game.addMovement(new Position(1,3), true);
    }
}
