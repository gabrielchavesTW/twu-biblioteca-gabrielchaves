package com.twu.biblioteca;

public class Book {
    int id;
    String name;
    String author;
    int year;
    boolean available;

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book(int id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = true;
    }
}
