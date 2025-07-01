package com.learning301.Solid.SRP.Goodcode;

/**
 * Implementation of ticket service that handles ticket-related operations.
 * This class follows the Single Responsibility Principle by focusing only on ticket management.
 */
public class TicketsBooking implements ITicketService {
    /** The seat number for this ticket */
    private int seatNo;
    
    /** The theater name where the show will be played */
    private String theater;

    /**
     * Creates a new ticket booking with specified seat and theater
     * 
     * @param seatNo The seat number for this booking
     * @param theater The theater name for this booking
     */
    public TicketsBooking(int seatNo, String theater){
        this.seatNo = seatNo;
        this.theater = theater;
    }

    /**
     * Displays the ticket information to the user
     */
    @Override
    public void showTicket(){
        System.out.println("Selected seat: " + seatNo + " in theater: " + theater);
    }
    
    /**
     * Prints a physical ticket for the booking
     */
    @Override
    public void printTicket(){
        System.out.println("Ticket printed for seat " + seatNo);
    }
}
