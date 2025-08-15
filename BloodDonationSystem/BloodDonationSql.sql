-- STEP 1: Create Database
CREATE DATABASE IF NOT EXISTS blood_donation;

-- STEP 2: Use the database
USE blood_donation;

-- STEP 3: Create Donors table
CREATE TABLE IF NOT EXISTS donors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    blood_group VARCHAR(10),
    location VARCHAR(100)
);

-- STEP 4: Create Donation History table
CREATE TABLE IF NOT EXISTS donation_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    donor_id INT,
    donation_date DATE,
    FOREIGN KEY (donor_id) REFERENCES donors(id)
);
