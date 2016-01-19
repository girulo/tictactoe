package nl.trifork.tictactoe.model;

/**
 * Created by hugo on 19-1-16.
 */
public class Move {

    private boolean player;
    private Position position;



//    public Move(int row, int column, Player player) {
//        Position position = new Position(row, column);
//        this.position = position;
//        this.player = player;
//    }

    public Move(Position position, boolean player) {
        this.position = position;
        this.player = player;
    }

    public boolean isPlayer() {
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
