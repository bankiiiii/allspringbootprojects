package com.rktech.rktech.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Book {
        private String title;
        private String author;
        private int pages;

        // Parameterless constructor
        public Book() {
            this.title = "";
            this.author = "";
            this.pages = 0;
        }

        // Parameterized constructor
        public Book(String title, String author, int pages) {
            this.title = title;
            this.author = author;
            this.pages = pages;
        }

        // Override the toString() method
        @Override
        public String toString() {
            return "Title: " + title + "\nAuthor: " + author + "\nPages: " + pages;
        }

//        public static void main(String[] args) {
//            // Example usage
//            Book book1 = new Book();
//            System.out.println("Book 1:\n" + book1);
//
//            Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);
//            System.out.println("\nBook 2:\n" + book2);
//        }
    }


