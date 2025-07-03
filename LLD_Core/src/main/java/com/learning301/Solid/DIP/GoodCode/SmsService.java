package com.learning301.Solid.DIP.GoodCode;

public class SmsService implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sent Sms " + message);
    }
}
