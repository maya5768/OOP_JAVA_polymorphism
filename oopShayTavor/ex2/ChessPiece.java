package oopShayTavor.ex2;

/**
 * Abstract base class for all chess pieces
 * Demonstrates polymorphism through abstract methods
 */
public abstract class ChessPiece {
    protected Position position;
    protected boolean isWhite;
    protected String name;
    
    /**
     * Constructor for ChessPiece
     * @param position the initial position
     * @param isWhite true if white piece, false if black
     * @param name the name of the piece
     */
    public ChessPiece(Position position, boolean isWhite, String name) {
        this.position = position;
        this.isWhite = isWhite;
        this.name = name;
    }
    
    /**
     * Abstract method to check if a move is valid
     * Each piece implements its own movement rules
     * @param newPosition the target position
     * @return true if the move is valid
     */
    public abstract boolean isValidMove(Position newPosition);
    
    /**
     * Abstract method to get all possible moves for this piece
     * @return array of valid positions this piece can move to
     */
    public abstract Position[] getPossibleMoves();
    
    /**
     * Move the piece to a new position
     * @param newPosition the target position
     * @return true if the move was successful
     */
    public boolean moveTo(Position newPosition) {
        if (isValidMove(newPosition)) {
            this.position = newPosition;
            return true;
        }
        return false;
    }
    
    /**
     * Get the current position
     * @return the current position
     */
    public Position getPosition() {
        return position;
    }
    
    /**
     * Set the position
     * @param position the new position
     */
    public void setPosition(Position position) {
        this.position = position;
    }
    
    /**
     * Check if this is a white piece
     * @return true if white, false if black
     */
    public boolean isWhite() {
        return isWhite;
    }
    
    /**
     * Get the piece name
     * @return the name of the piece
     */
    public String getName() {
        return name;
    }
    
    /**
     * Check if this piece can capture another piece
     * @param other the other piece
     * @return true if this piece can capture the other
     */
    public boolean canCapture(ChessPiece other) {
        if (other == null || this.isWhite == other.isWhite) {
            return false; // Cannot capture own pieces or null
        }
        return isValidMove(other.getPosition());
    }
    
    /**
     * Get the piece symbol for display
     * @return the symbol representing this piece
     */
    public abstract String getSymbol();
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " " + name + " at " + position;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChessPiece that = (ChessPiece) obj;
        return isWhite == that.isWhite && 
               position.equals(that.position) && 
               name.equals(that.name);
    }
}
