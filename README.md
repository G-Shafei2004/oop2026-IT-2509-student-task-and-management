# Student Task Management System - Milestone 2 (Assignment 4)

## Project Overview
This project is a Java-based Task Management System designed to help students manage their projects, tasks, and comments. This version (Milestone 2) upgrades the Assignment 3 architecture by implementing modern Java language features and professional Design Patterns.

## Team Members
* **Ghulam Ali Shafei**
* **Tursunbek Merey** 
---

## Assignment 4 Requirements (Checklist)

### 1. Design Patterns
* **Singleton Pattern**: Implemented in `DatabaseConnection.java`. It ensures that only one instance of the database connection exists throughout the application lifecycle to save resources.
* **Builder Pattern**: Implemented in `Task.java`. It provides a flexible way to create complex `Task` objects using a fluent API, making the code more readable and preventing constructor errors.
* **Factory Pattern**: Implemented in the `notification` package. The `NotificationFactory` creates different types of notifications (like `EmailNotification`) based on user input.

### 2. Language Features
* **Generics**: Created a universal interface `ICrudRepository<T>`. This allows all repositories (Tasks, Users, etc.) to share the same standard methods (save, find, delete) without code duplication.
* **Lambdas & Streams**: Used in `TaskService.java` inside the `getTasksByStatus` method. It uses `.stream().filter()` and lambda expressions to filter tasks efficiently in a single line.

### 3. New Functionality
* **Notification System**: A new scenario was added where the system automatically triggers a notification via the `NotificationFactory` whenever a new task is created.
