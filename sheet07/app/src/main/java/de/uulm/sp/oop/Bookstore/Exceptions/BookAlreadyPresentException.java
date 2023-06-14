package de.uulm.sp.oop.Bookstore.Exceptions;

public class BookAlreadyPresentException extends RuntimeException {
    public BookAlreadyPresentException() {
        super("Book is already present in Bookstore");
    }
}
