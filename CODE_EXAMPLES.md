# 💻 דוגמאות קוד לפולימורפיזם

## 1. מחלקה מופשטת - ChessPiece

```java
public abstract class ChessPiece {
    protected Position position;
    protected boolean isWhite;
    protected String name;
    
    // מתודות מופשטות - חובה לממש
    public abstract boolean isValidMove(Position newPosition);
    public abstract Position[] getPossibleMoves();
    public abstract String getSymbol();
    
    // מתודות קונקרטיות - משותפות לכל הכלים
    public boolean moveTo(Position newPosition) {
        if (isValidMove(newPosition)) {
            this.position = newPosition;
            return true;
        }
        return false;
    }
}
```

## 2. מחלקה קונקרטית - Bishop (רץ)

```java
public class Bishop extends ChessPiece {
    
    @Override
    public boolean isValidMove(Position newPosition) {
        // רץ זז רק אלכסונית
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());
        return rowDiff == colDiff && rowDiff > 0;
    }
    
    @Override
    public Position[] getPossibleMoves() {
        // חישוב כל התנועות האלכסוניות האפשריות
        // ... קוד לחישוב
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♗" : "♝";
    }
}
```

## 3. מחלקה קונקרטית - Knight (פרש)

```java
public class Knight extends ChessPiece {
    
    @Override
    public boolean isValidMove(Position newPosition) {
        // פרש זז בצורת L
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
    
    @Override
    public Position[] getPossibleMoves() {
        // חישוב כל התנועות בצורת L האפשריות
        // ... קוד לחישוב
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♘" : "♞";
    }
}
```

## 4. הדגמת פולימורפיזם - ChessBoard

```java
public class ChessBoard {
    private ChessPiece[] pieces; // מערך של ChessPiece - פולימורפיזם!
    
    // מתודה שמטפלת בכל הכלים באופן אחיד
    public boolean movePiece(ChessPiece piece, Position newPosition) {
        // כל כלי יודע לוודא את התנועה שלו
        if (piece.isValidMove(newPosition)) {
            piece.setPosition(newPosition);
            return true;
        }
        return false;
    }
    
    // הדגמת פולימורפיזם - אותה קריאה, התנהגות שונה
    public void displayAllPieces() {
        for (ChessPiece piece : pieces) {
            System.out.println(piece.getName() + ": " + piece.getSymbol());
            // כל כלי מחזיר את הסמל שלו
        }
    }
}
```

## 5. הדגמת זיהוי סוג בזמן ריצה

```java
public class ChessGame {
    public static void main(String[] args) {
        ChessPiece[] pieces = {
            new Bishop(new Position(0, 2), true),
            new Knight(new Position(0, 1), true)
        };
        
        // פולימורפיזם - אותה קריאה, התנהגות שונה
        for (ChessPiece piece : pieces) {
            System.out.println("Piece: " + piece.getName());
            System.out.println("Symbol: " + piece.getSymbol());
            
            // זיהוי סוג ספציפי
            if (piece instanceof Bishop) {
                Bishop bishop = (Bishop) piece;
                System.out.println("This is a bishop - moves diagonally");
            } else if (piece instanceof Knight) {
                Knight knight = (Knight) piece;
                System.out.println("This is a knight - moves in L-shape");
            }
        }
    }
}
```

## 6. דוגמה להרחבה - הוספת כלי חדש

```java
// הוספת כלי חדש - Queen (מלכה)
public class Queen extends ChessPiece {
    
    @Override
    public boolean isValidMove(Position newPosition) {
        // מלכה זזה כמו רץ או צריח
        // ... לוגיקה מורכבת
    }
    
    @Override
    public Position[] getPossibleMoves() {
        // חישוב כל התנועות האפשריות
        // ... קוד לחישוב
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♕" : "♛";
    }
}

// השימוש זהה - פולימורפיזם!
ChessPiece queen = new Queen(new Position(0, 3), true);
queen.isValidMove(newPosition); // עובד בדיוק כמו עם רץ או פרש
```

## 7. דוגמה לטיפול אחיד באובייקטים שונים

```java
public class GameManager {
    private ChessPiece[] allPieces;
    
    // מתודה שמטפלת בכל הכלים באופן אחיד
    public void moveAllPiecesToStart() {
        for (ChessPiece piece : allPieces) {
            // כל כלי יודע איך לזוז
            Position startPosition = getStartPosition(piece);
            piece.moveTo(startPosition);
        }
    }
    
    // מתודה שמדגימה פולימורפיזם
    public void displayPieceInfo() {
        for (ChessPiece piece : allPieces) {
            System.out.println("Name: " + piece.getName());
            System.out.println("Symbol: " + piece.getSymbol());
            System.out.println("Position: " + piece.getPosition());
            
            // כל כלי יודע לחשב את התנועות שלו
            Position[] moves = piece.getPossibleMoves();
            System.out.println("Possible moves: " + moves.length);
        }
    }
}
```

## נקודות חשובות להבנה 🎯

1. **פולימורפיזם** = אותה קריאה למתודה, התנהגות שונה
2. **העברה אחידה** = טיפול בכל האובייקטים דרך הממשק המשותף
3. **זיהוי סוג** = `instanceof` לזיהוי סוג ספציפי
4. **הרחבה** = הוספת כלים חדשים ללא שינוי בקוד הקיים

## שאלות לבדיקה עצמית ❓

1. מה ההבדל בין מחלקה מופשטת למחלקה רגילה?
2. איך פולימורפיזם עוזר לנו לכתוב קוד יותר גמיש?
3. מתי נשתמש ב-`instanceof`?
4. איך נוכל להוסיף כלי חדש (כמו צריח) בקלות?

**זכרו: הפולימורפיזם מאפשר לנו לכתוב קוד שמטפל באובייקטים שונים באופן אחיד! 🚀**
