#!/bin/bash

echo "╔════════════════════════════════════════╗"
echo "║     ONLINE STORE MANAGEMENT SYSTEM     ║"
echo "╚════════════════════════════════════════╝"
echo ""

# Check if compiled
if [ ! -d "com/onlinestore/ui" ]; then
    echo "❌ Project not compiled. Run ./compile.sh first!"
    exit 1
fi

# Run the main class
java com.onlinestore.ui.Main
