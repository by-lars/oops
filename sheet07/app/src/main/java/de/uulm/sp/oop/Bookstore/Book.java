package de.uulm.sp.oop.Bookstore;

public class Book {

    public Book(String title, int pageCount, String content) {
        this.title = title;
        this.pageCount = pageCount;
        this.content = content;
    }

    public final String title;
    public final int pageCount;
    public final String content;
}
