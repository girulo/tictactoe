package nl.trifork.tictactoe.model;

/**
 * Created by hugo on 19-1-16.
 */
public enum GameStatus {

    PLAYING ("Playing"),
    DRAW ("The game is DRAW"),
    PLAYER_X_WINS ("Player X Wins"),
    PLAYER_O_WINS ("Player O Wins");

    private String status;

    private GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
