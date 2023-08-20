package com.dyp.visitor;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Entry implements Element {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) {
        throw new FileTreatMentException("can not add entry to file");
    }

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
