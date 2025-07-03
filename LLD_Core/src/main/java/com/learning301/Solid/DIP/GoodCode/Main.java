package com.learning301.Solid.DIP.GoodCode;

public class Main {
    public static void main(String[] args) {
        NotificationService emailNotification = new NotificationService(new EmailService(), "Hello");
        emailNotification.notifyByChannel();


        NotificationService smsNotification = new NotificationService(new SmsService(), "Hello");
        smsNotification.notifyByChannel();

        NotificationService whatsAppNotification = new NotificationService(new WhatsappService(), "Hello");
        whatsAppNotification.notifyByChannel();

    }
}
