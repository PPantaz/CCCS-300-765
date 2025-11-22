@echo off
echo ╔════════════════════════════════════════╗
echo ║   COMPILING ONLINE STORE PROJECT      ║
echo ╚════════════════════════════════════════╝
echo.

echo 🔨 Compiling all Java files...
dir /s /B com\*.java > sources.txt
javac -d . @sources.txt

if %ERRORLEVEL% EQU 0 (
    echo ✅ Compilation successful!
    echo.
    echo 📂 Generated .class files in package directories
    echo 🚀 Run the program with: run.bat
    del sources.txt
) else (
    echo ❌ Compilation failed. Please check errors above.
    del sources.txt
    exit /b 1
)

pause
