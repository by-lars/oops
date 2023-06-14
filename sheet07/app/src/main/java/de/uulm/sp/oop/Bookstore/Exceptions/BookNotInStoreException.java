package de.uulm.sp.oop.Bookstore.Exceptions;

public class BookNotInStoreException extends Exception {
    public BookNotInStoreException() {
        super("Book is already in store");
    }
}
