package com.example.recyclerviewtest;

public class Book {
    private int ISBN;
    private String name;
    private int page;
    private boolean lent;

    public Book(int ISBN, String name, int page, boolean lent) {
        this.ISBN = ISBN;
        this.name = name;
        this.page = page;
        this.lent = lent;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isLent() {
        return lent;
    }

    public void setLent(boolean lent) {
        this.lent = lent;
    }
}
