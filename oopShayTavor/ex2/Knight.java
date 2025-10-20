package oopShayTavor.ex2;

/**
 * Knight chess piece implementation
 * Demonstrates polymorphism by implementing ChessPiece abstract methods
 */
public class Knight extends ChessPiece {
    
    /**
     * Constructor for Knight
     * @param position the initial position
     * @param isWhite true if white piece, false if black
     */
    public Knight(Position position, boolean isWhite) {
        super(position, isWhite, "Knight");
    }
    
    /**
     * Knight moves in L-shape (2 squares in one direction, 1 square perpendicular)
     * @param newPosition the target position
     * @return true if the move is valid
     */
    @Override
    public boolean isValidMove(Position newPosition) {
        if (newPosition == null || !newPosition.isValid()) {
            return false;
        }
        
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());
        
        // Knight moves in L-shape: (2,1) or (1,2)
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
    
    /**
     * Get all possible L-shaped moves for the knight
     * @return array of valid positions
     */
    @Override
    public Position[] getPossibleMoves() {
        java.util.List<Position> moves = new java.util.ArrayList<>();
        
        // All 8 possible knight moves
        int[][] knightMoves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        
        for (int[] move : knightMoves) {
            int newRow = position.getRow() + move[0];
            int newCol = position.getCol() + move[1];
            Position newPos = new Position(newRow, newCol);
            
            if (newPos.isValid()) {
                moves.add(newPos);
            }
        }
        
        return moves.toArray(new Position[0]);
    }
    
    /**
     * Get the knight symbol
     * @return the symbol for knight
     */
    @Override
    public String getSymbol() {
        return isWhite ? "♘" : "♞";
    }
    
    /**
     * Knight-specific method to check if it can jump over pieces
     * @return true (knights can jump over other pieces)
     */
    public boolean canJumpOverPieces() {
        return true;
    }
    
    /**
     * Get the knight's attack pattern
     * @return description of knight's attack pattern
     */
    public String getAttackPattern() {
        return "L-shaped moves, can jump over pieces";
    }
    
    /**
     * Check if the knight can fork (attack multiple pieces)
     * @param targets array of target positions
     * @return true if knight can attack multiple targets
     */
    public boolean canFork(Position[] targets) {
        int attackCount = 0;
        for (Position target : targets) {
            if (isValidMove(target)) {
                attackCount++;
            }
        }
        return attackCount >= 2;
    }
}
