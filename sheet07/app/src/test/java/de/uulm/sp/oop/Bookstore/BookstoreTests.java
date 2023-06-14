package de.uulm.sp.oop.Bookstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookstoreTests {

    static Bookstore store;

    @Before
    public void setUp() {
        store = new Bookstore();
        store.addToAssortment(new Book("Epic Book", 69, "A very epic book about epic adventures"));
        store.addToAssortment(new Book("How to not die from Math", 420, "You can't. :("));
        store.addToAssortment(new Book("How to java", 1, "idk I forgor"));
        store.addToAssortment(new Book("How to java (for real)", 1, "idk learn c++"));
    }

    @Test
    public void addToAssortment() {
        Assert.assertTrue(true);
    }

    @Test
    public void buyBook() {
        Assert.assertTrue(true);
    }
}