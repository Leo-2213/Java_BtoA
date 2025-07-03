package com.learning301.Solid.DIP.BadCode;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new EmailService(), new SmsService());

        notificationService.sendEmail("ghatiya code ");
        notificationService.sendSms("bahut ghatiya code");
    }
}
