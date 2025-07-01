package com.learning301.Solid.SRP.Goodcode;

/**
 * Orchestrates the ticket booking process by coordinating different components.
 * This class follows the Single Responsibility Principle by delegating specific
 * tasks to specialized service classes.
 */
public class Bookings {

    private final ITicketService ticketService;
    private final IEmailService emailService;
    private final IPaymentService paymentService;

    /**
     * Constructor with dependency injection for better testability and flexibility.
     * Using interfaces instead of concrete implementations allows for easy substitution.
     */
    public Bookings(ITicketService ticketService, IEmailService emailService, IPaymentService paymentService) {
        this.ticketService = ticketService;
        this.emailService = emailService;
        this.paymentService = paymentService;
    }

    /**
     * Executes the complete booking process.
     */
    public void bookTickets() {
        try {
            // Show ticket details
            ticketService.showTicket();
            
            // Process payment
            paymentService.makePayment(120);
            
            // Print physical ticket after payment
            ticketService.printTicket();
            
            // Send confirmation email
            emailService.sendEmail("abc@gmail.com");
            
            System.out.println("Booking completed successfully!");
        } catch (Exception e) {
            System.err.println("Booking failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create individual components
        ITicketService ticketService = new TicketsBooking(1, "PVR");
        IEmailService emailService = new EmailSender("support@tickets.com");
        IPaymentService paymentService = new Payment(0);
        
        // Create booking orchestrator with dependencies
        Bookings bookings = new Bookings(ticketService, emailService, paymentService);
        
        // Execute booking process
        bookings.bookTickets();
    }
}
