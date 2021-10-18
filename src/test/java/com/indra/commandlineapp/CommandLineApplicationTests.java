package com.indra.commandlineapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommandLineApplicationTests {
	private static final String URL = "https://postman-echo.com/time/now";

	@Autowired
	private RestTemplate restTemplate;

	@Test
	@DisplayName("Test whether the application context loads correctly")
	void testContextLoads() {
		assertNotNull(restTemplate);
	}

	@Test
	@DisplayName("Test http invocation")
	void testHttpRequestInvocation() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
}
