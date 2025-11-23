@echo off
echo ╔════════════════════════════════════════╗
echo ║     ONLINE STORE MANAGEMENT SYSTEM     ║
echo ╚════════════════════════════════════════╝
echo.

REM Check if compiled
if not exist "com\onlinestore\ui" (
    echo Project not compiled. Run compile.bat first!
    pause
    exit /b 1
)

REM Run the main class
java com.onlinestore.ui.Main

pause
