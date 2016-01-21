package nl.trifork.tictactoe.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getPosition());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if (player != other.player)
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }
}
