package oopShayTavor.ex2;

/**
 * Represents a position on a chess board
 */
public class Position {
    private int row;
    private int col;
    
    /**
     * Constructor for Position
     * @param row the row position (0-7)
     * @param col the column position (0-7)
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Get the row position
     * @return the row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Get the column position
     * @return the column
     */
    public int getCol() {
        return col;
    }
    
    /**
     * Set the row position
     * @param row the new row
     */
    public void setRow(int row) {
        this.row = row;
    }
    
    /**
     * Set the column position
     * @param col the new column
     */
    public void setCol(int col) {
        this.col = col;
    }
    
    /**
     * Check if this position is valid on a chess board
     * @return true if position is valid (0-7 for both row and col)
     */
    public boolean isValid() {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
    
    /**
     * Calculate the distance between this position and another
     * @param other the other position
     * @return the distance
     */
    public double distanceTo(Position other) {
        int rowDiff = Math.abs(this.row - other.row);
        int colDiff = Math.abs(this.col - other.col);
        return Math.sqrt(rowDiff * rowDiff + colDiff * colDiff);
    }
    
    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }
    
    @Override
    public int hashCode() {
        return row * 8 + col;
    }
}
