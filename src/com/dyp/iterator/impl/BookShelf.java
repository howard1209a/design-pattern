package com.dyp.iterator.impl;

import com.dyp.iterator.Aggregate;
import com.dyp.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public class BookShelf implements Aggregate {
    private List<Book> list = new ArrayList<>();

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public void addBook(Book book) {
        list.add(book);
    }

    public Book getBook(int num) {
        return list.get(num);
    }

    public Integer getBookNum() {
        return list.size();
    }
}
