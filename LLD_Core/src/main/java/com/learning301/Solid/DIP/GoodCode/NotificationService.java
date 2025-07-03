package com.learning301.Solid.DIP.GoodCode;

public class NotificationService {

    private NotificationChannel notificationChannel;
    private String msg;

    NotificationService(NotificationChannel notificationChannel, String msg){
        this.notificationChannel = notificationChannel;
        this.msg = msg;
    }

    public void notifyByChannel(){
        notificationChannel.sendNotification(msg);
    }
}
