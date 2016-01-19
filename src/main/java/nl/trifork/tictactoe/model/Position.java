package nl.trifork.tictactoe.model;

/**
 * Created by hugo on 19-1-16.
 */
public class Position {

    private int column;
    private int row;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean equals(Position position) {
        if (this.row == position.getRow() &&
                this.column == position.getColumn())
            return true;
        else
            return false;
    }
}
