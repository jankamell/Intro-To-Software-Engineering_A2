# Budget App

A simple desktop finance management system developed using Java and JavaFX for the Intro to Software Engineering course project.

## Project Overview

Budget App is a desktop application that helps users manage their personal finances in a simple and organized way. The system allows users to track income and expenses, manage budgets, generate reports, search transactions, manage savings goals, and convert currencies.

The project was developed using Java, JavaFX, and the MVC architecture pattern.

---

# Technologies Used

* Java 17
* JavaFX
* Maven
* IntelliJ IDEA
* JavaDoc

---

# Project Structure

```plaintext
src/
 ├── app
 ├── controllers
 ├── models
 ├── services
 ├── storage
 └── ui
```

---

# Architecture

The project follows the MVC architecture:

## Models

Contain system data and business entities.

Examples:

* User
* Transaction
* Expense
* Income
* Goal

## Views (UI)

Contain JavaFX screens and user interfaces.

Examples:

* LoginView
* DashboardView
* BudgetView
* ReportView

## Controllers

Connect the UI with services and handle user actions.

Examples:

* AuthController
* BudgetController
* GoalController

## Services

Contain business logic and calculations.

Examples:

* BudgetService
* ReportService
* CurrencyService

---

# Features

## 1. Authentication

* User login
* User registration
* User validation

## 2. Transaction Management

* Add income
* Add expense
* Display transaction history
* Categorize transactions

## 3. Budget Management

* Set budget limit
* Calculate spending
* Calculate remaining balance
* Display usage percentage
* Display budget warnings

## 4. Reports

* Generate financial reports
* Display total income
* Display total expenses
* Display balance
* Integrate budget statistics into reports

## 5. Search

* Search transactions by category

## 6. Goals

* Create saving goals
* Track goal progress
* Update goal progress

## 7. Currency Converter

* Convert amounts between currencies
* Show original and converted values

---

# Budget System Improvements

The budget module was enhanced with:

* Remaining balance calculation
* Usage percentage calculation
* Dynamic warning system
* Budget status analysis

Possible budget states:

* Budget is under control
* Warning: Near budget
* Budget exceeded

---

# Documentation

The project documentation was generated using JavaDoc.

Documentation includes:

* Classes
* Methods
* Parameters
* Package structure

Generated documentation folder:

```plaintext
doc/
```

Main documentation file:

```plaintext
doc/index.html
```

---

# How to Run the Project

## Requirements

* Java 17 or later
* Maven
* JavaFX
* IntelliJ IDEA

---

## Run Using Maven

Open terminal inside the project folder and run:

```bash
mvn javafx:run
```

---

# Team Members Responsibilities

## Member 1

Authentication and core system

Files:

* MainApp
* LoginView
* AuthController
* AuthService
* User

---

## Member 2

Transactions and Budget

Files:

* TransactionView
* TransactionController
* TransactionService
* BudgetView
* BudgetController
* BudgetService

---

## Member 3

Search and Reports

Files:

* SearchView
* SearchController
* SearchService
* ReportView
* ReportController
* ReportService

---

## Member 4

Goals, Currency, and UI

Files:

* GoalView
* GoalController
* GoalService
* SettingsView
* CurrencyService
* UIHelper

---

# Coding Style

The project follows Java coding conventions including:

* CamelCase naming
* Proper indentation
* Separation of concerns
* Clean MVC structure
* JavaDoc documentation

---

# Future Improvements

Possible future enhancements:

* Database integration
* Charts and graphs
* Export reports to PDF
* Multi-user support
* Dark mode

---

# Conclusion

This project demonstrates the use of:

* Object-Oriented Programming (OOP)
* MVC Architecture
* JavaFX GUI Development
* Software Engineering Principles
* JavaDoc Documentation

The application provides a complete and user-friendly finance management experience while maintaining clean and organized code.
