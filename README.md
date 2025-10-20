# 🎯 תרגיל פולימורפיזם - משחק שחמט

## 📋 תוכן העניינים
- [הוראות התרגיל](#הוראות-התרגיל)
- [מבנה הפרויקט](#מבנה-הפרויקט)
- [איך להריץ](#איך-להריץ)
- [דוגמאות קוד](#דוגמאות-קוד)
- [מושגי פולימורפיזם](#מושגי-פולימורפיזם)

## 🎯 הוראות התרגיל

### מטרת התרגיל
התרגיל נועד להדגים ולהבין את מושג הפולימורפיזם (Polymorphism) ב-Java באמצעות יצירת משחק שחמט פשוט.

### דרישות עיקריות
1. **מחלקה מופשטת** - `ChessPiece` עם מתודות מופשטות
2. **מחלקות קונקרטיות** - `Bishop` (רץ) ו-`Knight` (פרש)
3. **לוח שחמט** - `ChessBoard` עם מערך של `ChessPiece`
4. **הדגמת פולימורפיזם** - טיפול אחיד באובייקטים שונים

### כללי התנועה
| כלי | תנועה | הערות |
|-----|-------|-------|
| רץ | אלכסונית | לא יכול לדלג |
| פרש | צורת L | יכול לדלג |

## 📁 מבנה הפרויקט

```
OOP JAVA polymorpizm/
├── oopShayTavor/
│   └── ex2/
│       ├── ChessPiece.java      (מחלקה מופשטת)
│       ├── Bishop.java          (רץ)
│       ├── Knight.java          (פרש)
│       ├── Position.java        (מיקום)
│       ├── ChessBoard.java      (לוח שחמט)
│       └── ChessGame.java       (מחלקה ראשית)
├── README.md
├── EXERCISE_INSTRUCTIONS.md     (הוראות מפורטות)
├── QUICK_START.md               (מדריך מהיר)
├── CODE_EXAMPLES.md             (דוגמאות קוד)
├── compile_and_run.bat          (סקריפט הרצה)
└── POLYMORPHISM_SUMMARY.md      (סיכום מושגים)
```

## 🚀 איך להריץ

### אפשרות 1: שימוש בסקריפט
```bash
compile_and_run.bat
```

### אפשרות 2: הרצה ידנית
```bash
cd oopShayTavor\ex2
javac *.java
cd ..\..
java oopShayTavor.ex2.ChessGame
```

## 💻 דוגמאות קוד

### 1. מחלקה מופשטת
```java
public abstract class ChessPiece {
    // מתודות מופשטות - חובה לממש
    public abstract boolean isValidMove(Position newPosition);
    public abstract Position[] getPossibleMoves();
    public abstract String getSymbol();
}
```

### 2. פולימורפיזם במתודות
```java
// אותה קריאה למתודה, התנהגות שונה
ChessPiece[] pieces = {new Bishop(...), new Knight(...)};
for (ChessPiece piece : pieces) {
    piece.isValidMove(position); // כל כלי יודע לוודא את התנועה שלו
}
```

### 3. זיהוי סוג בזמן ריצה
```java
if (piece instanceof Bishop) {
    Bishop bishop = (Bishop) piece;
    // שימוש במתודות ספציפיות לרץ
}
```

## 🎓 מושגי פולימורפיזם

### 1. **מחלקה מופשטת (Abstract Class)**
- מגדירה ממשק משותף לכל המחלקות היורשות
- מכילה מתודות מופשטות שחובה לממש
- לא ניתנת ליצירה ישירה

### 2. **העברה אחידה (Uniform Treatment)**
- טיפול בכל האובייקטים דרך הממשק המשותף
- אותה קריאה למתודה, התנהגות שונה
- גמישות וקלות תחזוקה

### 3. **זיהוי סוג בזמן ריצה (Runtime Type Identification)**
- שימוש ב-`instanceof` לזיהוי סוג ספציפי
- המרה בטוחה של סוגים
- שימוש במתודות ספציפיות

### 4. **הרחבה (Extensibility)**
- הוספת כלים חדשים ללא שינוי בקוד הקיים
- עקרון פתוח/סגור (Open/Closed Principle)
- קוד גמיש וניתן להרחבה

## 📚 קבצים נוספים

- **[EXERCISE_INSTRUCTIONS.md](EXERCISE_INSTRUCTIONS.md)** - הוראות מפורטות לתרגיל
- **[QUICK_START.md](QUICK_START.md)** - מדריך מהיר להתחלה
- **[CODE_EXAMPLES.md](CODE_EXAMPLES.md)** - דוגמאות קוד מפורטות
- **[POLYMORPHISM_SUMMARY.md](POLYMORPHISM_SUMMARY.md)** - סיכום מושגי הפולימורפיזם

## ✅ נקודות לבדיקה עצמית

- [ ] האם המחלקה המופשטת מוגדרת נכון?
- [ ] האם המחלקות הקונקרטיות מממשות את כל המתודות המופשטות?
- [ ] האם הקוד מדגים פולימורפיזם?
- [ ] האם ניתן להוסיף כלי חדש בקלות?
- [ ] האם הקוד נקי ומתועד?

## 🎯 מטרות למידה

לאחר השלמת התרגיל, תבינו:
- איך לעצב מחלקות מופשטות
- איך לממש העברה של מתודות
- איך פולימורפיזם מאפשר טיפול אחיד באובייקטים שונים
- איך להשתמש בזיהוי סוג בזמן ריצה
- איך לעצב מערכות מונחות-אובייקטים הניתנות להרחבה

**בהצלחה! 🚀**
