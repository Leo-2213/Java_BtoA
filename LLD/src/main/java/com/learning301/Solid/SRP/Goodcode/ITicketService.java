package com.learning301.Solid.SRP.Goodcode;

/**
 * Interface for ticket-related operations.
 * This interface follows the Single Responsibility Principle by focusing only on ticket operations.
 */
public interface ITicketService {
    /**
     * Displays ticket information to the user
     */
    void showTicket();
    
    /**
     * Prints a physical or digital ticket
     */
    void printTicket();
}