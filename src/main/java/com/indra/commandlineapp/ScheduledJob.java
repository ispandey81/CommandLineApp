package com.indra.commandlineapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledJob {

    private static final Logger log = LoggerFactory.getLogger(ScheduledJob.class);

    private static final String URL = "https://postman-echo.com/time/now";

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedRate = 5000)
    public void scheduleFixedRateTask() {
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
            // logging to console as well as an application log file called CommandLineApplication.log
            log.info(responseEntity.getBody());
            // logging to console as well as an application log file called CommandLineApplication.log
            log.info(responseEntity.getStatusCode().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
