package nl.trifork.tictactoe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

/**
 * Here we have implemented all the Logic of the game
 */
public class Game {


    private List<Move> movesDone;
    private GameStatus actualStatus;
//    private Map<Position, Player> board;


    /**
     * Constructor. It initializes the status of the game and the list of Moves
     */
    public Game() {
        this.actualStatus = GameStatus.PLAYING;
        this.movesDone = new ArrayList<>();
    }

    /**
     * Add a movement to the game and check the status of the game
     * @param position is the position that the user clicked
     * @param player is the player that is doing a move (X or O)
     *
     * @return the new status of the game
     */
    public GameStatus addMovement(Position position, boolean player) {

        //Our movement
        if (isAvailable(position)) {
            movesDone.add(new Move(position, player));
            //} else //send message to JS and ask for a new movement
            if (isDraw())
                actualStatus = GameStatus.DRAW;
            else if (isWinner(player))
                if (player == true)
                    actualStatus = GameStatus.PLAYER_X_WINS;
                else
                    actualStatus = GameStatus.PLAYER_O_WINS;
        }
        return actualStatus;


    }

    /**
     * Makes a random Move for the computer
     * @param computer player that makes a move, that will be the computer
     *
     * @return the id in String format of the cell that was made the Move
     */
    public String addComputerMovement(boolean computer) {

        boolean validPosition = false;
        Position position = null;
        do {
            position = Position.randomPosition();

            if(isAvailable(position)) {
                movesDone.add(new Move(position, computer));
                validPosition = true;
            }
        }
        while(!validPosition);
        return String.format("%d%d", position.getRow(), position.getColumn());
    }

    /**
     * Chek if the given position is available (no player occupied it yet)
     * @param position the position to be checked
     *
     * @return true if it is available, otherwise false
     */
    private boolean isAvailable (Position position) {

        boolean available = true;
        for (Move move: movesDone) {
            if (move.getPosition().equals(position))
                available = false;
        }
        return available;
    }

    /**
     * Creates a list with all the possible combination that makes a player win the game
     *
     * @return a list with the possible winning combinations
     */
    private static List<List<Position>> getAllPossibleWinningCombinations() {

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

    /**
     * Check if the given player is a winner or not
     *
     * @param player the player to check if is a winner or not
     *
     * @return true is the given player wins, otherwiser false
     */
    private boolean isWinner(boolean player) {

        boolean isWinner = false;
        List<Position> movesFromPlayer = getPlayerPositions(player);

        if(movesFromPlayer.size() >= 3)
            for(List<Position> winningList : getAllPossibleWinningCombinations()) {
                if (movesFromPlayer.containsAll(winningList)) {
                    isWinner = true;
                    break;
                }
            }
        return isWinner;
    }

    /**
     * Check that the game is Draw (nobody wins)
     *
     * @return true if the game is draw, otherwise false
     */
    boolean isDraw() {

        return (!isWinner(true)
                && !isWinner(false)
                && movesDone.size() == 9);
    }

    /**
     * Get the Positions where for the given player where he already clicked
     *
     * @param player is the player to check positions
     *
     * @return a list with all the cell that eh clicked before
     */
    private List<Position> getPlayerPositions(boolean player) {

        List<Position> playerMoves = new ArrayList<>();

        for (Move move : movesDone) {
            if (move.getPlayer() == player)
                playerMoves.add(move.getPosition());

        }
        return playerMoves;
    }

    /**
     * Returns the actual status of the game
     * @return
     */
    public GameStatus getActualStatus() {
        return actualStatus;
    }


    public void restart() {
        movesDone.clear();
        actualStatus = GameStatus.PLAYING;
    }
}
