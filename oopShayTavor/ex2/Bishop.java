package oopShayTavor.ex2;

/**
 * Bishop chess piece implementation
 * Demonstrates polymorphism by implementing ChessPiece abstract methods
 */
public class Bishop extends ChessPiece {
    
    /**
     * Constructor for Bishop
     * @param position the initial position
     * @param isWhite true if white piece, false if black
     */
    public Bishop(Position position, boolean isWhite) {
        super(position, isWhite, "Bishop");
    }
    
    /**
     * Bishop moves diagonally any number of squares
     * @param newPosition the target position
     * @return true if the move is valid
     */
    @Override
    public boolean isValidMove(Position newPosition) {
        if (newPosition == null || !newPosition.isValid()) {
            return false;
        }
        
        // Bishop moves diagonally
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());
        
        // Must move diagonally (equal row and column differences)
        return rowDiff == colDiff && rowDiff > 0;
    }
    
    /**
     * Get all possible diagonal moves for the bishop
     * @return array of valid positions
     */
    @Override
    public Position[] getPossibleMoves() {
        java.util.List<Position> moves = new java.util.ArrayList<>();
        
        // Check all four diagonal directions
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        for (int[] direction : directions) {
            for (int i = 1; i < 8; i++) {
                int newRow = position.getRow() + direction[0] * i;
                int newCol = position.getCol() + direction[1] * i;
                Position newPos = new Position(newRow, newCol);
                
                if (newPos.isValid()) {
                    moves.add(newPos);
                } else {
                    break; // Stop if we go off the board
                }
            }
        }
        
        return moves.toArray(new Position[0]);
    }
    
    /**
     * Get the bishop symbol
     * @return the symbol for bishop
     */
    @Override
    public String getSymbol() {
        return isWhite ? "♗" : "♝";
    }
    
    /**
     * Bishop-specific method to check if it can attack a position
     * @param targetPosition the position to check
     * @return true if the bishop can attack this position
     */
    public boolean canAttack(Position targetPosition) {
        return isValidMove(targetPosition);
    }
    
    /**
     * Get the bishop's diagonal range
     * @return the maximum diagonal distance the bishop can move
     */
    public int getDiagonalRange() {
        return 7; // Bishop can move up to 7 squares diagonally
    }
}
