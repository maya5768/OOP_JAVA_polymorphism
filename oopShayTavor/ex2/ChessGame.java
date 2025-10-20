package oopShayTavor.ex2;

/**
 * Main class to demonstrate polymorphism in chess
 * This class shows how different chess pieces can be treated uniformly
 */
public class ChessGame {
    
    public static void main(String[] args) {
        System.out.println("=== Chess Game - Polymorphism Demo ===\n");
        
        // Create a chess board
        ChessBoard board = new ChessBoard();
        
        // Create different types of chess pieces
        // Demonstrates polymorphism - all pieces are ChessPiece objects
        ChessPiece whiteBishop = new Bishop(new Position(0, 2), true);
        ChessPiece blackBishop = new Bishop(new Position(7, 5), false);
        ChessPiece whiteKnight = new Knight(new Position(0, 1), true);
        ChessPiece blackKnight = new Knight(new Position(7, 6), false);
        
        // Add pieces to the board
        System.out.println("Adding pieces to the board...");
        board.addPiece(whiteBishop);
        board.addPiece(blackBishop);
        board.addPiece(whiteKnight);
        board.addPiece(blackKnight);
        
        // Display the board
        System.out.println(board.toString());
        
        // Demonstrate polymorphism - treat all pieces uniformly
        System.out.println("=== Demonstrating Polymorphism ===");
        ChessPiece[] allPieces = {whiteBishop, blackBishop, whiteKnight, blackKnight};
        
        for (ChessPiece piece : allPieces) {
            System.out.println("\n" + piece.getName() + " (" + piece.getSymbol() + "):");
            System.out.println("  Current position: " + piece.getPosition());
            System.out.println("  Color: " + (piece.isWhite() ? "White" : "Black"));
            
            // Each piece knows how to validate its own moves
            Position[] possibleMoves = piece.getPossibleMoves();
            System.out.println("  Possible moves: " + possibleMoves.length);
            
            // Show first few possible moves
            for (int i = 0; i < Math.min(3, possibleMoves.length); i++) {
                System.out.println("    - " + possibleMoves[i]);
            }
            if (possibleMoves.length > 3) {
                System.out.println("    ... and " + (possibleMoves.length - 3) + " more");
            }
        }
        
        // Demonstrate moving pieces
        System.out.println("\n=== Moving Pieces ===");
        
        // Try to move the white bishop diagonally
        Position newPos = new Position(2, 4);
        System.out.println("Attempting to move white bishop to " + newPos + "...");
        if (board.movePiece(whiteBishop, newPos)) {
            System.out.println("Move successful! Bishop is now at " + whiteBishop.getPosition());
        } else {
            System.out.println("Move failed!");
        }
        
        // Try to move the knight in L-shape
        Position knightPos = new Position(2, 3);
        System.out.println("Attempting to move white knight to " + knightPos + "...");
        if (board.movePiece(whiteKnight, knightPos)) {
            System.out.println("Move successful! Knight is now at " + whiteKnight.getPosition());
        } else {
            System.out.println("Move failed!");
        }
        
        // Demonstrate piece-specific methods
        System.out.println("\n=== Piece-Specific Methods ===");
        
        // Bishop-specific method
        if (whiteBishop instanceof Bishop) {
            Bishop bishop = (Bishop) whiteBishop;
            System.out.println("Bishop can attack position (4,6): " + bishop.canAttack(new Position(4, 6)));
            System.out.println("Bishop diagonal range: " + bishop.getDiagonalRange());
        }
        
        // Knight-specific method
        if (whiteKnight instanceof Knight) {
            Knight knight = (Knight) whiteKnight;
            System.out.println("Knight can jump over pieces: " + knight.canJumpOverPieces());
            System.out.println("Knight attack pattern: " + knight.getAttackPattern());
        }
        
        // Show final board state
        System.out.println("\n=== Final Board State ===");
        System.out.println(board.toString());
        System.out.println("Piece counts: " + board.getPieceCounts());
        
        // Demonstrate capturing
        System.out.println("\n=== Capture Demonstration ===");
        System.out.println("White bishop can capture black bishop: " + 
                          whiteBishop.canCapture(blackBishop));
        System.out.println("White bishop can capture white knight: " + 
                          whiteBishop.canCapture(whiteKnight));
        
        // Show polymorphism in action - different pieces, same interface
        System.out.println("\n=== Polymorphism in Action ===");
        demonstratePolymorphism(board);
    }
    
    /**
     * Demonstrates polymorphism by treating different piece types uniformly
     * @param board the chess board
     */
    private static void demonstratePolymorphism(ChessBoard board) {
        System.out.println("All pieces can be treated as ChessPiece objects:");
        
        ChessPiece[] pieces = board.getPiecesByColor(true); // Get white pieces
        
        for (ChessPiece piece : pieces) {
            // Polymorphism: same method call, different behavior
            System.out.println("Piece: " + piece.getName());
            System.out.println("  Symbol: " + piece.getSymbol());
            System.out.println("  Position: " + piece.getPosition());
            
            // Each piece implements its own movement logic
            Position[] moves = piece.getPossibleMoves();
            System.out.println("  Valid moves: " + moves.length);
            
            // Test a specific move
            if (moves.length > 0) {
                Position testMove = moves[0];
                boolean isValid = piece.isValidMove(testMove);
                System.out.println("  Can move to " + testMove + ": " + isValid);
            }
        }
    }
}
