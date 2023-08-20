package com.dyp.chain_of_responsibility;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next == null) {
            fail(trouble);
        } else {
            next.support(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble);

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " can not be resolved.");
    }
}
