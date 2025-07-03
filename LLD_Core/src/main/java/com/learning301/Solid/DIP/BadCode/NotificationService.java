package com.learning301.Solid.DIP.BadCode;

public class NotificationService {

    private EmailService emailService;
    private SmsService smsService;

    NotificationService(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }
    public void sendEmail(String msg) {
        emailService.sendEmail(msg);
    }
    public void sendSms(String msg) {
        smsService.sendSms(msg);
    }
}
