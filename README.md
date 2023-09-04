# BookWise-LibraSuite

Welcome to the BookWise LibraSuite, a comprehensive library management system designed to simplify the organization and administration of your book collection.

## Features

- **Effortless Book Addition**: Seamlessly add new books to your library by providing the title and author information.
- **Efficient Viewing**: Quickly view your entire library to gain insights into your collection.
- **Title-Based Search**: Easily search for books in your library by title.
- **Flexible Updates**: Keep your book details up-to-date, including titles and authors.
- **Graceful Deletion**: Remove books from your collection with ease.
- **User-Friendly Interface**: Navigate the application effortlessly, with straightforward exit options.

## Getting Started

1. **Clone the Repository**: Clone this repository to your local machine.
2. **Database Setup**: please set up the required database as per the provided following SQL instructions.
 (create database if it does not exists)
 
CREATE DATABASE IF NOT EXISTS yourDataBaseName;

(Switch to the your database)

USE yourDataBaseName;

(Create the books table to store book information)


CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);


(feel free to add more features as per your need and update them accordingly in code!!)

4. **Run the Application**: Launch the application from your terminal to begin managing your library efficiently.

## Thank You
Safeer Alam
