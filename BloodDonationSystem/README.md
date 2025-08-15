# 🩸 Blood Donation Management System

A simple Java-based console application to manage blood donors, donation history, and request tracking using **JDBC** and **MySQL**.

## Features

- Register new blood donors
- Search donors by blood group and location
- View all registered donors
- Track donation history and last donated date
- Admin access for managing records
- Persistent storage using MySQL

## Tech Stack

- Java (Core): OOP, Collections, Exception Handling
- JDBC (Java Database Connectivity)
- MySQL
- IDE: VS Code
- No build tool (pure Java project)

## Project Structure

BloodDonationSystem/
├── src/
│ ├── BloodDonationMain.java
│ ├── Admin.java
│ ├── DbConnection.java
│ └── DonationHistoryManager.java
├── blood_donation_schema.sql


## How to Run

1. Install MySQL on your system.
2. Import `blood_donation_schema.sql` to create tables.
3. Update MySQL username & password in `DbConnection.java`.
4. Compile and run `BloodDonationMain.java` from VS Code or terminal.
5. Use the console menu to register/search/view donor info.

## Java Concepts Used

- OOP: Classes like Donor, Admin, DonationHistoryManager
- Collections: List, Map
- Exception Handling: Input validation, DB errors
- JDBC: Connection, PreparedStatement, ResultSet
- SQL Filtering & Joins
- Working with Dates (last donation tracking)

## Author

- **Name:**  Andrewson J

> “Save lives with every line of code.” 💻❤️🩸
