package nl.trifork.tictactoe.model;

/**
 * Created by hugo on 19-1-16.
 */
public enum Player {

    X (true),
    O (false);

    private boolean value;

    Player(boolean value) {
        this.value = value;
    }
    boolean getValue() {
        return this.value;
    }
}
