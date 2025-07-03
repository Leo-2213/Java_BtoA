package com.learning301.Solid.DIP.GoodCode;

public class WhatsappService implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sent Whatsapp msg " + message);
    }
}
