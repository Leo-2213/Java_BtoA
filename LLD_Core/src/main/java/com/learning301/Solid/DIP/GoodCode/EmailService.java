package com.learning301.Solid.DIP.GoodCode;

public class EmailService implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sent Email " + message);
    }
}
