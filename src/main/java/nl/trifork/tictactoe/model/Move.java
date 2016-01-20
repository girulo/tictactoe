package nl.trifork.tictactoe.model;

/**
 * Created by hugo on 19-1-16.
 */
public class Move {

    private boolean player;
    private Position position;


    public Move(Position position, boolean player) {
        this.position = position;
        this.player = player;
    }

    public boolean getPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
