package com.dyp.composite;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public abstract Entry getParent();

    public abstract void setParent(Entry parent);

    public Entry add(Entry entry) {
        throw new FileTreatMentException("can not add entry to file");
    }

    public void printList() {
        printList("");
    }

    public abstract void printList(String prefix);

    public abstract void printPath();

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
