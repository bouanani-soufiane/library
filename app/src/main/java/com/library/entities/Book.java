package com.library.entities;

public class Book {

    private long ISBN;
    private String title;
    private String author;
    private int quantity;

    public Book () {
    }

    public Book ( long ISBN, String title, String author, int quantity ) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public long getISBN () {
        return ISBN;
    }

    public String getTitle () {
        return title;
    }

    public String getAuthor () {
        return author;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setISBN ( long ISBN ) {
        this.ISBN = ISBN;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public void setAuthor ( String author ) {
        this.author = author;
    }

    public void setQuantity ( int quantity ) {
        this.quantity = quantity;
    }
}
