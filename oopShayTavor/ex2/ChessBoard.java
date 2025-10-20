package oopShayTavor.ex2;

/**
 * ChessBoard class that demonstrates polymorphism
 * Uses an array of ChessPiece objects to store different types of pieces
 */
public class ChessBoard {
    private ChessPiece[] pieces;
    private int pieceCount;
    private static final int MAX_PIECES = 32; // Maximum pieces on a chess board
    
    /**
     * Constructor for ChessBoard
     */
    public ChessBoard() {
        pieces = new ChessPiece[MAX_PIECES];
        pieceCount = 0;
    }
    
    /**
     * Add a piece to the board
     * Demonstrates polymorphism by accepting any ChessPiece subclass
     * @param piece the piece to add
     * @return true if the piece was added successfully
     */
    public boolean addPiece(ChessPiece piece) {
        if (piece == null || pieceCount >= MAX_PIECES) {
            return false;
        }
        
        // Check if position is already occupied
        if (isPositionOccupied(piece.getPosition())) {
            return false;
        }
        
        pieces[pieceCount] = piece;
        pieceCount++;
        return true;
    }
    
    /**
     * Remove a piece from the board
     * @param piece the piece to remove
     * @return true if the piece was removed successfully
     */
    public boolean removePiece(ChessPiece piece) {
        if (piece == null) {
            return false;
        }
        
        for (int i = 0; i < pieceCount; i++) {
            if (pieces[i] != null && pieces[i].equals(piece)) {
                // Shift remaining pieces to fill the gap
                for (int j = i; j < pieceCount - 1; j++) {
                    pieces[j] = pieces[j + 1];
                }
                pieces[pieceCount - 1] = null;
                pieceCount--;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get a piece at a specific position
     * @param position the position to check
     * @return the piece at that position, or null if empty
     */
    public ChessPiece getPieceAt(Position position) {
        if (position == null || !position.isValid()) {
            return null;
        }
        
        for (int i = 0; i < pieceCount; i++) {
            if (pieces[i] != null && pieces[i].getPosition().equals(position)) {
                return pieces[i];
            }
        }
        return null;
    }
    
    /**
     * Check if a position is occupied
     * @param position the position to check
     * @return true if the position is occupied
     */
    public boolean isPositionOccupied(Position position) {
        return getPieceAt(position) != null;
    }
    
    /**
     * Move a piece to a new position
     * Demonstrates polymorphism by calling moveTo on any ChessPiece
     * @param piece the piece to move
     * @param newPosition the target position
     * @return true if the move was successful
     */
    public boolean movePiece(ChessPiece piece, Position newPosition) {
        if (piece == null || newPosition == null || !newPosition.isValid()) {
            return false;
        }
        
        // Check if the piece is on the board
        boolean pieceOnBoard = false;
        for (int i = 0; i < pieceCount; i++) {
            if (pieces[i] == piece) {
                pieceOnBoard = true;
                break;
            }
        }
        
        if (!pieceOnBoard) {
            return false;
        }
        
        // Check if target position is occupied by own piece
        ChessPiece targetPiece = getPieceAt(newPosition);
        if (targetPiece != null && targetPiece.isWhite() == piece.isWhite()) {
            return false;
        }
        
        // Use polymorphism - each piece knows how to validate its own moves
        if (piece.isValidMove(newPosition)) {
            // If target position has an enemy piece, capture it
            if (targetPiece != null) {
                removePiece(targetPiece);
            }
            
            // Move the piece
            piece.setPosition(newPosition);
            return true;
        }
        
        return false;
    }
    
    /**
     * Get all pieces of a specific color
     * @param isWhite true for white pieces, false for black pieces
     * @return array of pieces of the specified color
     */
    public ChessPiece[] getPiecesByColor(boolean isWhite) {
        java.util.List<ChessPiece> colorPieces = new java.util.ArrayList<>();
        
        for (int i = 0; i < pieceCount; i++) {
            if (pieces[i] != null && pieces[i].isWhite() == isWhite) {
                colorPieces.add(pieces[i]);
            }
        }
        
        return colorPieces.toArray(new ChessPiece[0]);
    }
    
    /**
     * Get all possible moves for a specific piece
     * Demonstrates polymorphism by calling getPossibleMoves on any ChessPiece
     * @param piece the piece to get moves for
     * @return array of possible positions
     */
    public Position[] getPossibleMovesForPiece(ChessPiece piece) {
        if (piece == null) {
            return new Position[0];
        }
        
        // Use polymorphism - each piece knows its own possible moves
        return piece.getPossibleMoves();
    }
    
    /**
     * Count pieces by type
     * Demonstrates polymorphism by using instanceof to identify piece types
     * @return string with piece counts
     */
    public String getPieceCounts() {
        int bishops = 0, knights = 0, other = 0;
        
        for (int i = 0; i < pieceCount; i++) {
            if (pieces[i] != null) {
                if (pieces[i] instanceof Bishop) {
                    bishops++;
                } else if (pieces[i] instanceof Knight) {
                    knights++;
                } else {
                    other++;
                }
            }
        }
        
        return String.format("Bishops: %d, Knights: %d, Other: %d", bishops, knights, other);
    }
    
    /**
     * Get the current number of pieces on the board
     * @return the number of pieces
     */
    public int getPieceCount() {
        return pieceCount;
    }
    
    /**
     * Clear the board
     */
    public void clearBoard() {
        for (int i = 0; i < pieceCount; i++) {
            pieces[i] = null;
        }
        pieceCount = 0;
    }
    
    /**
     * String representation of the board
     * Demonstrates polymorphism by calling toString on each piece
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chess Board with ").append(pieceCount).append(" pieces:\n");
        
        for (int i = 0; i < pieceCount; i++) {
            if (pieces[i] != null) {
                sb.append(i + 1).append(". ").append(pieces[i].toString()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
