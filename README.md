# 📚 Java OOP Practice - Library Management System

This is a Java practice project that simulates a **library management system** using Object-Oriented Programming (OOP). It is intended to be completed in **~120 minutes** as a practice assessment.

---

## To start the assessment create a branch or clone the repo...Don't push to main

## ⏱ Duration

**Target Time:** 120 minutes  
**Focus Areas:** Classes, Inheritance, Abstraction, Encapsulation, Polymorphism

---

## ✅ Objective

Build a console-based library system that allows users to:
- Add books to the system
- Register members
- Borrow and return books
- Track available and borrowed books
- Display member borrowing history

---

## 🧱 Key Requirements

- Use `ArrayList` to store books and members in memory
- Use `Scanner` for CLI input
- Focus on clean class design and object interaction

---

## 🧩 Classes

### 📖 Abstract Class: `LibraryItem`
- Fields:
    - `String id`
    - `String title`
    - `boolean isAvailable`
- Abstract Method: `void displayInfo()`
- Methods:
    - `getId()`, `getTitle()`, `isAvailable()`, `setAvailable(boolean)`

---

### 📗 Class: `Book` (extends `LibraryItem`)
- Extra Field: `String author`
- Implements `displayInfo()` to print book info

---

### 👤 Class: `Member`
- Fields:
    - `String memberId`
    - `String name`
    - `ArrayList<LibraryItem> borrowedItems`
- Methods:
    - `borrowItem(LibraryItem item)`
    - `returnItem(LibraryItem item)`
    - `displayBorrowedItems()`

---

### 🏛️ Class: `LibraryService`
- Stores `ArrayList<Book> books` and `ArrayList<Member> members`
- Methods:
    - `addBook(Book book)`
    - `registerMember(Member member)`
    - `borrowBook(String memberId, String bookId)`
    - `returnBook(String memberId, String bookId)`
    - `listAvailableBooks()`
    - `listBorrowedBooksByMember(String memberId)`

---

### 🖥️ Class: `Main`
**Console menu** to interact with the system:

```text
===== Library Menu =====
1. Add Book
2. Register Member
3. Borrow Book
4. Return Book
5. View Available Books
6. View Borrowed Books by Member
7. Exit

```

---
## Example workflow
> Add Book
Enter title: Java 101
Enter author: Jane Doe

> Register Member
Enter name: Alex

> Borrow Book
Enter member ID: M001
Enter book ID: B001

> View Available Books
[Shows remaining books only]

---
## Project structure
```commandline
src/
├── Main.java
├── model/
│   ├── LibraryItem.java
│   ├── Book.java
│   └── Member.java
├── service/
│   └── LibraryService.java
```

