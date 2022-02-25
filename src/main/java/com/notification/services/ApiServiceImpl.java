package com.notification.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cvs.notification.client.NotificationRequest;

@Service
public class ApiServiceImpl implements ApiService {
	@Autowired
	private RestTemplate restTemplate;

	// inject value from application.properties
	@Value("${api.url}")
	private String API_URL;

	@Override
	public String sendNotification(List<NotificationRequest> payload) {

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(API_URL);
		HttpHeaders headers = new HttpHeaders();
		headers.add("idToken", "");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<NotificationRequest>> entity = new HttpEntity<List<NotificationRequest>>(payload, headers);
		try {
			String str = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, entity, String.class).getBody();
			System.out.println(str);
			return str;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return null;
	}
}
