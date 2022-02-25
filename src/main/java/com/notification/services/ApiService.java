package com.notification.services;

import java.io.IOException;
import java.util.List;

import com.cvs.notification.client.NotificationRequest;

public interface ApiService
{
    String  sendNotification(List<NotificationRequest> payload) throws IOException;
}
