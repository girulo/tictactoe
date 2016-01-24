package nl.trifork.tictactoe.model;

/**
 * Created by hugo on 23/01/16.
 */
public class MoveResults {

    private String computerMovePosition;
    private String status;
    private int maxScore;


    public String getComputerMovePosition() {
        return computerMovePosition;
    }

    public void setComputerMovePosition(String computerMovePosition) {
        this.computerMovePosition = computerMovePosition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
