# Budget App

A simple desktop finance management system developed using Java and JavaFX for the Intro to Software Engineering course project.

## Project Overview

Budget App is a desktop application that helps users manage their personal finances in a simple and organized way. The system allows users to track income and expenses, manage budgets, generate reports, search transactions, manage savings goals, and convert currencies.

The project was developed using Java, JavaFX, and the MVC architecture pattern.

## Technologies Used

Java 17, JavaFX, Maven, IntelliJ IDEA, JavaDoc

## Project Structure

src folder contains app, controllers, models, services, storage, and ui packages.

## Architecture

The project follows the MVC architecture.

Models contain system data and business entities like User, Transaction, Expense, Income, and Goal.

Views contain JavaFX screens and user interfaces like LoginView, DashboardView, BudgetView, and ReportView.

Controllers connect the UI with services and handle user actions like AuthController, BudgetController, and GoalController.

Services contain business logic and calculations like BudgetService, ReportService, and CurrencyService.

## Features

Authentication includes user login, registration, and validation.

Transaction Management lets you add income and expenses, display transaction history, and categorize transactions.

Budget Management lets you set a budget limit, calculate spending, calculate remaining balance, display usage percentage, and display budget warnings.

Reports generate financial reports showing total income, total expenses, balance, and budget statistics.

Search lets you find transactions by category.

Goals let you create saving goals, track progress, and update progress.

Currency Converter converts amounts between currencies and shows original and converted values.

## Budget System Improvements

The budget module was enhanced with remaining balance calculation, usage percentage calculation, a dynamic warning system, and budget status analysis. Possible budget states are under control, near budget, and exceeded.

## Documentation

Project documentation was generated using JavaDoc and includes classes, methods, parameters, and package structure. The generated documentation is in the doc folder and the main file is doc/index.html.

## How to Run

You need Java 17 or later, Maven, JavaFX, and IntelliJ IDEA. Open a terminal in the project folder and run mvn javafx:run.

## Team Responsibilities

Member 1 handled authentication and core system with files like MainApp, LoginView, AuthController, AuthService, and User.

Member 2 handled transactions and budget with files like TransactionView, TransactionController, TransactionService, BudgetView, BudgetController, and BudgetService.

Member 3 handled search and reports with files like SearchView, SearchController, SearchService, ReportView, ReportController, and ReportService.

Member 4 handled goals, currency, and UI with files like GoalView, GoalController, GoalService, SettingsView, CurrencyService, and UIHelper.

## Coding Style

The project follows Java coding conventions including CamelCase naming, proper indentation, separation of concerns, clean MVC structure, and JavaDoc documentation.

## Future Improvements

Possible future enhancements include database integration, charts and graphs, PDF export, multi-user support, and dark mode.

## Conclusion

This project demonstrates Object-Oriented Programming, MVC Architecture, JavaFX GUI Development, Software Engineering Principles, and JavaDoc Documentation. The application provides a complete and user-friendly finance management experience while maintaining clean and organized code.
