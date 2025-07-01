package com.learning301.Solid.SRP.Goodcode;

/**
 * Interface for email notification services.
 * This interface follows the Single Responsibility Principle by focusing only on email operations.
 */
public interface IEmailService {
    /**
     * Sends an email to the specified recipient
     * 
     * @param recipientEmail The email address of the recipient
     */
    void sendEmail(String recipientEmail);
}