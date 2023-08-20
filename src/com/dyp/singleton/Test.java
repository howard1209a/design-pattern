package com.dyp.singleton;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        TicketMaker ticketMaker1 = TicketMaker.getInstance();
        TicketMaker ticketMaker2 = TicketMaker.getInstance();
        System.out.println(ticketMaker1 == ticketMaker2);
        Triple triple1 = Triple.getInstance(1);
        Triple triple2 = Triple.getInstance(2);
        Triple triple3 = Triple.getInstance(3);
        System.out.println(triple1);
        System.out.println(triple2);
        System.out.println(triple3);
        System.out.println(triple1);
    }
}
