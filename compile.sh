#!/bin/bash

echo "╔════════════════════════════════════════╗"
echo "║   COMPILING ONLINE STORE PROJECT      ║"
echo "╚════════════════════════════════════════╝"
echo ""

# Find all Java files and compile them
echo "🔨 Compiling all Java files..."
find com -name "*.java" > sources.txt
javac -d . @sources.txt

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo ""
    echo "📂 Generated .class files in package directories"
    echo "🚀 Run the program with: ./run.sh"
    rm sources.txt
else
    echo "❌ Compilation failed. Please check errors above."
    rm sources.txt
    exit 1
fi
