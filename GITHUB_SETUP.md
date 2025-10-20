# 🚀 הוראות העלאה ל-GitHub

## 📍 מיקום הפרויקט
הפרויקט נמצא בתיקייה: `OOP JAVA polymorpizm/`

## 🔧 שלבי ההעלאה ל-GitHub

### שלב 1: יצירת Repository חדש ב-GitHub
1. היכנסו ל-GitHub.com
2. לחצו על "New repository"
3. שם ה-Repository: `OOP-JAVA-polymorphism`
4. תיאור: `Java Polymorphism Exercise - Chess Game`
5. בחרו "Public" או "Private"
6. **אל תסמנו** "Add a README file"
7. לחצו "Create repository"

### שלב 2: הכנת הפרויקט להעלאה
```bash
# נווטו לתיקיית הפרויקט
cd "OOP JAVA polymorpizm"

# אתחול Git repository
git init

# הוספת כל הקבצים
git add .

# יצירת commit ראשון
git commit -m "Initial commit: Java Polymorphism Chess Game"

# הוספת remote origin (החליפו את USERNAME ב-GitHub username שלכם)
git remote add origin https://github.com/USERNAME/OOP-JAVA-polymorphism.git

# העלאה ל-GitHub
git push -u origin main
```

### שלב 3: וידוא שהכל עובד
1. בדקו שהקוד מתקמפל:
   ```bash
   cd oopShayTavor\ex2
   javac *.java
   cd ..\..
   java oopShayTavor.ex2.ChessGame
   ```

2. וידוא שהקבצים הבאים קיימים:
   - `README.md`
   - `EXERCISE_INSTRUCTIONS.md`
   - `QUICK_START.md`
   - `CODE_EXAMPLES.md`
   - `POLYMORPHISM_SUMMARY.md`
   - `PROJECT_SUMMARY.md`
   - `compile_and_run.bat`

## 📁 מבנה הפרויקט ב-GitHub

לאחר ההעלאה, הפרויקט ייראה כך ב-GitHub:

```
OOP-JAVA-polymorphism/
├── README.md                    (קובץ ראשי)
├── EXERCISE_INSTRUCTIONS.md     (הוראות מפורטות)
├── QUICK_START.md               (מדריך מהיר)
├── CODE_EXAMPLES.md             (דוגמאות קוד)
├── POLYMORPHISM_SUMMARY.md      (סיכום מושגים)
├── PROJECT_SUMMARY.md           (סיכום הפרויקט)
├── GITHUB_SETUP.md              (קובץ זה)
├── compile_and_run.bat          (סקריפט הרצה)
└── oopShayTavor/
    └── ex2/
        ├── ChessPiece.java      (מחלקה מופשטת)
        ├── Bishop.java          (רץ)
        ├── Knight.java          (פרש)
        ├── Position.java        (מיקום)
        ├── ChessBoard.java      (לוח שחמט)
        └── ChessGame.java       (מחלקה ראשית)
```

## 🎯 מה יופיע ב-GitHub

### 1. **README.md** - הקובץ הראשי
- הסבר על הפרויקט
- הוראות הרצה
- דוגמאות קוד
- מושגי פולימורפיזם

### 2. **קבצי Java** (בתיקיית oopShayTavor/ex2/)
- כל קבצי ה-Java עם הקוד המלא
- מחלקה מופשטת ומחלקות קונקרטיות
- הדגמת פולימורפיזם

### 3. **קבצי תיעוד**
- הוראות מפורטות לתרגיל
- דוגמאות קוד מפורטות
- מדריכי הרצה
- סיכום מושגים

### 4. **קבצי עזר**
- סקריפט הרצה ל-Windows
- הוראות העלאה ל-GitHub

## ✅ בדיקות לפני ההעלאה

- [ ] כל קבצי ה-Java קיימים
- [ ] הקוד מתקמפל ללא שגיאות
- [ ] README.md קיים ומפורט
- [ ] כל קבצי התיעוד קיימים
- [ ] הפרויקט פועל כהלכה

## 🔗 קישורים שיופיעו ב-GitHub

לאחר ההעלאה, תוכלו לשתף:
- **Repository URL**: `https://github.com/USERNAME/OOP-JAVA-polymorphism`
- **Clone URL**: `https://github.com/USERNAME/OOP-JAVA-polymorphism.git`

## 📝 הערות חשובות

1. **שם הפרויקט**: `OOP-JAVA-polymorphism`
2. **תיאור**: Java Polymorphism Exercise - Chess Game
3. **שפת הפרויקט**: Java
4. **תגיות**: polymorphism, java, oop, chess, abstract-class

## 🎉 לאחר ההעלאה

הפרויקט יהיה זמין ב-GitHub עם:
- קוד מלא ומתועד
- הוראות ברורות
- דוגמאות מפורטות
- הדגמת פולימורפיזם

**הפרויקט מוכן להעלאה! 🚀**
