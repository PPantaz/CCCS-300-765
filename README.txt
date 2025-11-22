╔════════════════════════════════════════════════════════════════╗
║       ONLINE STORE MANAGEMENT SYSTEM - COMPLETE PROJECT       ║
║                   All 8 Requirements Met ✅                    ║
╚════════════════════════════════════════════════════════════════╝

🎓 SCHOOL PROJECT - PROGRAMMING TECHNIQUES I (CCCS 300 765)

═══════════════════════════════════════════════════════════════
📋 REQUIREMENTS CHECKLIST - ALL IMPLEMENTED
═══════════════════════════════════════════════════════════════

✅ 1. Arrays/ArrayLists
   - Product.reviews (ArrayList<ProductReview>)
   - ShoppingCart.products (ArrayList<Product>)
   - OrderHistory.orders (ArrayList<Order>)
   - Order.products (ArrayList<Product>)
   - Main.catalog (ArrayList<Product>)

✅ 2. Custom Exception Classes
   - InvalidPaymentException
   - EmptyCartException
   - ProductNotFoundException

✅ 3. Recursive Methods (7 methods in RecursiveUtils)
   - factorial(n)
   - calculateTotalRecursive()
   - countProductsRecursive()
   - findMaxPriceRecursive()
   - fibonacci(n)
   - sumToN(n)
   - power(base, exponent)

✅ 4. Searching Algorithms (SearchAlgorithms class)
   - linearSearch()
   - binarySearch()
   - recursiveBinarySearch()

✅ 5. Sorting Algorithms (SortingAlgorithms class)
   - bubbleSort()
   - selectionSort()
   - insertionSort()

✅ 6. Input Validation (InputValidator class)
   - getIntInput() - validates integer range
   - getDoubleInput() - validates decimal input
   - getStringInput() - validates non-empty strings
   - getEmailInput() - validates email format
   - isValidCreditCard() - validates card numbers
   - getConfirmation() - validates yes/no input

✅ 7. File Persistence (DataPersistence class)
   - saveProducts() / loadProducts()
   - saveOrders() / loadOrders()
   - saveUser() / loadUser()
   - exportCartToText()

✅ 8. Multi-Option Console Menu (Main class)
   - 15 menu options
   - Full navigation system
   - Error handling throughout

═══════════════════════════════════════════════════════════════
📁 PROJECT STRUCTURE
═══════════════════════════════════════════════════════════════

OnlineStoreComplete/
├── com/
│   └── onlinestore/
│       ├── exceptions/           (3 files)
│       │   ├── InvalidPaymentException.java
│       │   ├── EmptyCartException.java
│       │   └── ProductNotFoundException.java
│       │
│       ├── model/                (10 files)
│       │   ├── Product.java
│       │   ├── Electronics.java
│       │   ├── Clothing.java
│       │   ├── Grocery.java
│       │   ├── ProductReview.java
│       │   ├── Payment.java
│       │   ├── CreditCardPayment.java
│       │   ├── PayPalPayment.java
│       │   ├── Order.java
│       │   ├── OrderHistory.java
│       │   └── User.java
│       │
│       ├── service/              (1 file)
│       │   └── ShoppingCart.java
│       │
│       ├── utils/                (4 files)
│       │   ├── SearchAlgorithms.java
│       │   ├── SortingAlgorithms.java
│       │   ├── RecursiveUtils.java
│       │   ├── InputValidator.java
│       │   └── DataPersistence.java
│       │
│       └── ui/                   (1 file)
│           └── Main.java
│
├── compile.sh                    (Compilation script)
├── run.sh                        (Execution script)
└── README.txt                    (This file)

TOTAL: 19 Java files + 3 scripts/docs = 22 files

═══════════════════════════════════════════════════════════════
🚀 QUICK START GUIDE
═══════════════════════════════════════════════════════════════

STEP 1: Compile the Project
────────────────────────────
Linux/Mac:
  $ chmod +x compile.sh
  $ ./compile.sh

Windows:
  > javac -d . com/onlinestore/**/*.java

STEP 2: Run the Application
────────────────────────────
Linux/Mac:
  $ chmod +x run.sh
  $ ./run.sh

Windows:
  > java com.onlinestore.ui.Main

═══════════════════════════════════════════════════════════════
🎯 MENU OPTIONS OVERVIEW
═══════════════════════════════════════════════════════════════

1.  📋 Browse Products         - View all 15 products in catalog
2.  ➕ Add to Cart             - Add products to shopping cart
3.  🛒 View Cart               - See cart contents and totals
4.  🗑️  Remove from Cart        - Remove items from cart
5.  💰 Apply Discount          - Apply percentage discount
6.  💳 Checkout                - Process payment (demonstrates exceptions)
7.  📦 Order History           - View past orders
8.  ⭐ Leave Review            - Rate and review products
9.  🔍 Search Products         - Test search algorithms
10. 📊 Sort Products           - Test sorting algorithms
11. 🔢 Recursive Demos         - Test 7 recursive methods
12. 💾 Save Data               - Save to files (persistence)
13. 📂 Load Data               - Load from files
14. 👤 User Info               - View/edit user information
15. 🚪 Exit                    - Close application

═══════════════════════════════════════════════════════════════
📊 FEATURES DEMONSTRATION
═══════════════════════════════════════════════════════════════

EXCEPTION HANDLING:
- Try checkout with empty cart → EmptyCartException
- Try invalid payment → InvalidPaymentException
- Robust input validation prevents crashes

ALGORITHMS:
- Search: Linear, Binary, Recursive Binary Search
- Sort: Bubble, Selection, Insertion Sort
- Comparison counts and timing displayed

RECURSIVE METHODS:
- Mathematical: Factorial, Fibonacci, Power
- Cart operations: Total calculation, counting
- List operations: Max price finder

FILE PERSISTENCE:
- Auto-save option for products, orders, users
- Data persists between sessions
- Text export functionality

═══════════════════════════════════════════════════════════════
🧪 TESTING GUIDE
═══════════════════════════════════════════════════════════════

TEST 1: Basic Shopping Flow
1. Browse products (option 1)
2. Add 3-5 products to cart (option 2)
3. View cart (option 3)
4. Apply 10% discount (option 5)
5. Checkout with credit card (option 6)
6. View order history (option 7)

TEST 2: Exception Handling
1. Try to checkout empty cart → See EmptyCartException
2. Try invalid payment → See InvalidPaymentException
3. Enter invalid inputs → See validation messages

TEST 3: Search Algorithms
1. Go to option 9
2. Test Linear Search for "Laptop"
3. Test Binary Search for "T-Shirt"
4. Compare performance metrics

TEST 4: Sorting Algorithms
1. Go to option 10
2. Try Bubble Sort by name
3. Try Selection Sort by price
4. Compare comparisons/swaps

TEST 5: Recursive Methods
1. Go to option 11
2. Test Factorial(5) = 120
3. Test Fibonacci(10) = 55
4. Test Cart Total (recursive)

TEST 6: File Persistence
1. Add items to cart
2. Save data (option 12)
3. Exit program (option 15)
4. Restart program
5. Load data (option 13)
6. Verify data restored

═══════════════════════════════════════════════════════════════
🎓 OBJECT-ORIENTED PRINCIPLES DEMONSTRATED
═══════════════════════════════════════════════════════════════

INHERITANCE:
- Product (abstract) → Electronics, Clothing, Grocery
- Payment (abstract) → CreditCardPayment, PayPalPayment

POLYMORPHISM:
- calculateDiscountedPrice() - different implementations
- processPayment() - different payment methods
- displayDetails() - different product displays

ENCAPSULATION:
- Private fields with public getters/setters
- Protected access where appropriate
- Immutable data through defensive copying

ABSTRACTION:
- Abstract Product and Payment classes
- Interface-like patterns in utilities

═══════════════════════════════════════════════════════════════
💡 TIPS FOR PRESENTATION
═══════════════════════════════════════════════════════════════

1. Start with README to show organization
2. Demonstrate each requirement clearly:
   - Show ArrayList usage in code
   - Trigger exceptions intentionally
   - Run recursive demos
   - Show algorithm comparisons
   - Demonstrate file save/load

3. Highlight code quality:
   - Proper package structure
   - Comprehensive JavaDoc comments
   - Error handling throughout
   - Clean separation of concerns

4. Show UML diagrams (if required)
5. Discuss design decisions
6. Run thorough testing scenarios

═══════════════════════════════════════════════════════════════
📝 REQUIREMENTS MAPPING
═══════════════════════════════════════════════════════════════

Requirement 1 (Arrays/ArrayLists):
→ Look at: Product.java line 15, ShoppingCart.java line 15,
           OrderHistory.java line 13, Order.java line 18

Requirement 2 (Custom Exceptions):
→ Look at: exceptions/ folder (3 files)
→ Usage: Main.java checkout() method

Requirement 3 (Recursive Methods):
→ Look at: RecursiveUtils.java (7 methods)
→ Demo: Main.java recursiveDemo()

Requirement 4 (Search Algorithms):
→ Look at: SearchAlgorithms.java
→ Demo: Main.java searchProductsDemo()

Requirement 5 (Sort Algorithms):
→ Look at: SortingAlgorithms.java
→ Demo: Main.java sortProductsDemo()

Requirement 6 (Input Validation):
→ Look at: InputValidator.java
→ Usage: Throughout Main.java

Requirement 7 (File Persistence):
→ Look at: DataPersistence.java
→ Usage: Main.java saveAllData(), loadSavedData()

Requirement 8 (Multi-Option Menu):
→ Look at: Main.java displayMainMenu(), handleMenuChoice()
→ Demo: Run the application

═══════════════════════════════════════════════════════════════
🐛 TROUBLESHOOTING
═══════════════════════════════════════════════════════════════

Problem: "package com.onlinestore does not exist"
Solution: Make sure you're in the project root directory
          and compile with: javac -d . com/onlinestore/**/*.java

Problem: "NoClassDefFoundError"
Solution: Make sure CLASSPATH includes current directory
          Run from project root: java com.onlinestore.ui.Main

Problem: Data not saving
Solution: Check file permissions in current directory
          Ensure write access for .dat files

Problem: Scanner issues
Solution: Make sure you press Enter after each input
          Don't close Scanner prematurely

═══════════════════════════════════════════════════════════════
✅ FINAL CHECKLIST
═══════════════════════════════════════════════════════════════

Before submission, verify:
□ All 19 Java files compile without errors
□ All 8 requirements demonstrated
□ Program runs from start to finish
□ Menu navigation works correctly
□ Exception handling works
□ Algorithms produce correct output
□ File save/load works
□ Code is well-commented
□ Package structure is correct
□ README is included

═══════════════════════════════════════════════════════════════
📧 PROJECT INFO
═══════════════════════════════════════════════════════════════

Project:  Online Store Management System
Course:   Programming Techniques I (CCCS 300 765)
Features: Complete implementation of all 8 requirements
Files:    19 Java classes + documentation
Status:   ✅ Production ready

═══════════════════════════════════════════════════════════════
