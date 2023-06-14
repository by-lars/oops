package de.uulm.sp.oop.Bookstore;

import de.uulm.sp.oop.Bookstore.Exceptions.BookAlreadyPresentException;
import de.uulm.sp.oop.Bookstore.Exceptions.BookNotInStoreException;

import java.util.HashMap;

public class Bookstore {

    public Bookstore() {
        m_Books = new HashMap<>();
    }

    public void addToAssortment(Book book) {
        if(m_Books.containsKey(book.title))
            throw new BookAlreadyPresentException();

        m_Books.put(book.title, book);
    }

    public Book buyBook(String title) throws BookNotInStoreException {
        if(!m_Books.containsKey(title))
            throw new BookNotInStoreException();

        return m_Books.get(title);
    }

    private HashMap<String, Book> m_Books;
}
