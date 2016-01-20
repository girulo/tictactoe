package nl.trifork.tictactoe.model;

import java.util.concurrent.ThreadLocalRandom;

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

    //To be able to work with list and use well containsAll, etc
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        if (this == obj)
            return true;

        Position otherPosition = (Position) obj;
        if (this.column != otherPosition.column)
            return false;
        if (this.row != otherPosition.row)
            return false;
        return true;
    }

    public static Position randomPosition() {

        int row = ThreadLocalRandom.current().nextInt(0, 3);
        int column = ThreadLocalRandom.current().nextInt(0, 3);

        return new Position(row, column);
    }
}
