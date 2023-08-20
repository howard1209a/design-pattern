package com.dyp.singleton;

/**
 * @author howard
 * @version 1.0
 */
public class TicketMaker {
    private int ticket = 1000;
    private static final TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {
    }

    public int getNextTickerNumber() {
        return ticket++;
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }
}
