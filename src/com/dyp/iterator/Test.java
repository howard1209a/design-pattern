package com.dyp.iterator;

import com.dyp.iterator.impl.Book;
import com.dyp.iterator.impl.BookShelf;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new Book("a", 1));
        bookShelf.addBook(new Book("b", 2));
        bookShelf.addBook(new Book("c", 3));
        bookShelf.addBook(new Book("d", 4));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
