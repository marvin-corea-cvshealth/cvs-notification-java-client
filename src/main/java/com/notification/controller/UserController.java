package com.notification.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cvs.notification.client.NotificationRequest;
import com.notification.services.ApiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@Autowired
	private ApiService apiService;
	
	@PostMapping(value = "/emailNotification", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmailNotification(@RequestBody List<NotificationRequest> payload) {
		try {
			return apiService.sendNotification(payload);
		} catch (IOException e) {
			System.out.println("Error");
		}
		return "failed";
	}
}
