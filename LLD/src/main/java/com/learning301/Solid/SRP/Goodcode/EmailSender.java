package com.learning301.Solid.SRP.Goodcode;

/**
 * Implementation of email service that handles email notifications.
 * This class follows the Single Responsibility Principle by focusing only on email operations.
 */
public class EmailSender implements IEmailService {

    /** The email address used as the sender for all emails */
    private String senderEmail;

    /**
     * Creates a new email sender with the specified sender address
     * 
     * @param senderEmail The email address to use as the sender
     */
    public EmailSender(String senderEmail){
        this.senderEmail = senderEmail;
    }

    /**
     * Sends an email to the specified recipient
     * 
     * @param recipientEmail The email address of the recipient
     */
    @Override
    public void sendEmail(String recipientEmail){
        System.out.println("Email sent from " + senderEmail + " to: " + recipientEmail);
    }
}
