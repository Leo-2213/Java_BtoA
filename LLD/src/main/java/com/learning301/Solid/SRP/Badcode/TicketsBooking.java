package com.learning301.Solid.SRP.Badcode;

/**
 * This class demonstrates a violation of the Single Responsibility Principle (SRP).
 * It handles multiple responsibilities: booking, printing, payment, and email notification.
 */
public class TicketsBooking {
    /**
     * Books tickets for the user
     */
    public void bookTickets(){
        System.out.println("Tickets booked");
    }
    
    /**
     * Prints the booked tickets
     */
    public void printTickets(){
        System.out.println("Tickets printed");
    }
    
    /**
     * Processes the payment for tickets
     */
    public void payment(){
        System.out.println("payment done");
    }
    
    /**
     * Sends confirmation email to the user
     */
    public void sendEmail(){
        System.out.println("email sent");
    }

    /**
     * Main method to demonstrate the ticket booking process
     */
    public static void main(String[] args) {
        TicketsBooking ticketsBooking = new TicketsBooking();

        // Complete ticket booking workflow
        ticketsBooking.bookTickets();
        ticketsBooking.printTickets();
        ticketsBooking.payment();
        ticketsBooking.sendEmail();
    }

}
