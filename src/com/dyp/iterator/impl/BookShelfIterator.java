package com.dyp.iterator.impl;

import com.dyp.iterator.Iterator;
import com.dyp.iterator.impl.BookShelf;

/**
 * @author howard
 * @version 1.0
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index = 0;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getBookNum() ? true : false;
    }

    @Override
    public Object next() {
        return bookShelf.getBook(index++);
    }
}
