@echo off
echo Compiling Java files...
cd oopShayTavor\ex2
javac *.java

if %errorlevel% equ 0 (
    echo Compilation successful!
    echo.
    echo Running Chess Game...
    echo =====================
    cd ..\..
    java oopShayTavor.ex2.ChessGame
) else (
    echo Compilation failed!
    pause
)
