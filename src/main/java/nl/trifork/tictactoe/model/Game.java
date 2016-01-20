package nl.trifork.tictactoe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

/**
 *
 */
public class Game {

    private List<Move> movesDone;
    private GameStatus actualStatus;
//    private Map<Position, Player> board;
    
    
    public Game() {
        this.actualStatus = GameStatus.PLAYING;
        this.movesDone = new ArrayList<>();
    }

    public GameStatus addMovement(Position position, boolean player, boolean computer) {

        //Our movement
        if (isAvailable(position)) {
            movesDone.add(new Move(position, player));
            //} else //send message to JS and ask for a new movement
        }

        //Computer random Movement
        addComputerMovement(computer);

        if (isDraw())
            actualStatus = GameStatus.DRAW;
        else if (isWinner(player))
            actualStatus = GameStatus.PLAYER_X_WINS;
        else if (isWinner(computer))
            actualStatus = GameStatus.PLAYER_O_WINS;

        return actualStatus;

    }

    public void addComputerMovement(boolean computer) {

        boolean validPosition = false;
        do {
            Position position = Position.randomPosition();

            if(isAvailable(position)) {
                movesDone.add(new Move(position, computer));
                validPosition = true;
            }
        }
        while(!validPosition);
    }

    private boolean isAvailable (Position position) {

        boolean available = true;
        for (Move move: movesDone) {
            if (move.getPosition().equals(position))
                available = false;
        }
        return available;
    }

    /**
     * This method returns all the possibles combination that can make the player wins
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

    private boolean isWinner(boolean player) {

        List<Position> movesFromPlayer = getPlayerPositions(player);

        for(List<Position> winningList : getAllPossibleWinningCombinations()) {
            if (movesFromPlayer.containsAll(winningList))
                System.out.println("True");
            else System.out.print("False");
        }
        return player;
    }

    boolean isDraw() {

        return (!isWinner(true)
                && !isWinner(false)
                && movesDone.size() == 9);
    }


    private List<Position> getPlayerPositions(boolean player) {

        List<Position> playerMoves = new ArrayList<>();

        for (Move move : movesDone) {
            if (move.getPlayer() == player)
                playerMoves.add(move.getPosition());

        }
        return playerMoves;
    }

    public GameStatus getActualStatus() {
        return actualStatus;
    }


}
