package nl.trifork.tictactoe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 *
 */
public class Game {

    private List<Move> movesDone;
    private GameStatus actualStatus;
    private Map<Position, Player> board;
    
    
    public Game() {
        this.actualStatus = GameStatus.PLAYING;
        this.movesDone = new ArrayList<>();
    }

    public void addMovement(Position position, boolean player) {

        if (isAvailable(position)) {
            movesDone.add(new Move(position, player));
        }

        //else send message to JS and ask for a new movement

        if (isWinner(Player.X))
            actualStatus = GameStatus.PLAYER_X_WINS;
        else if (isWinner(Player.O))
            actualStatus = GameStatus.PLAYER_O_WINS;
        else if (isDraw())
            actualStatus = GameStatus.DRAW;
    }

    private boolean isAvailable (Position position) {

        boolean available = true;
        for (Move move: movesDone) {
            Position p = move.getPosition();
            available = false;
        }
        return available;
    }

    /**
     * This method returns all the possibles combination that can make the player wins
     *
     * @return a list with the possible winning combinations
     */
    private static List<List<Position>> getAllPossibleWinningcombinations() {

        List<List<Position>> winningLists = new ArrayList<List<Position>>();

        //Winning Rows
        winningLists.add(asList(new Position(1, 1), new Position(1, 2), new Position(1, 3)));
        winningLists.add(asList(new Position(2, 1), new Position(2, 2), new Position(2, 3)));
        winningLists.add(asList(new Position(3, 1), new Position(3, 2), new Position(3, 3)));

        //Winning Columns
        winningLists.add(asList(new Position(1, 1), new Position(2, 1), new Position(3, 1)));
        winningLists.add(asList(new Position(1, 2), new Position(2, 2), new Position(3, 2)));
        winningLists.add(asList(new Position(1, 3), new Position(2, 3), new Position(3, 3)));

        //Winning Diagonals
        winningLists.add(asList(new Position(1, 1), new Position(2, 2), new Position(3, 3)));
        winningLists.add(asList(new Position(3, 1), new Position(2, 2), new Position(1, 3)));

        return winningLists;
    }

    private boolean isWinner(Player player) {

        List<Move> movesFromPlayer = getPlayerMoves(player);
        for(Position position : board) {

        }
    }

    private List<Move> getPlayerMoves(Player player) {
    }

    public void addMovement(Move move) {
    }
}
