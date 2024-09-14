package com.entropool.benchmark.ssrf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SuppressWarnings("unchecked")
public class SpringController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getForEntity")
    public ResponseEntity<String> getForEntity(@RequestParam String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // Get the response status code
        System.out.println("Response Status Code: " + responseEntity.getStatusCode());
        // Get the response body
        String responseBody = responseEntity.getBody();
        System.out.println("Response Body: " + responseBody);
        return responseEntity;
    }

    @GetMapping("/exchange")
    public ResponseEntity<String> exchange(@RequestParam String url) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // Get the response status code
        System.out.println("Response Status Code: " + responseEntity.getStatusCode());
        // Get the response body
        String responseBody = responseEntity.getBody();
        System.out.println("Response Body: " + responseBody);
        return responseEntity;
    }

    @GetMapping("/execute")
    public ResponseEntity<String> execute(@RequestParam String url) {
        ResponseEntity<String> responseEntity = restTemplate.execute(url, HttpMethod.GET, null, null);

        // Get the response status code
        System.out.println("Response Status Code: " + responseEntity.getStatusCode());
        // Get the response body
        String responseBody = responseEntity.getBody();
        System.out.println("Response Body: " + responseBody);
        return responseEntity;
    }

    @GetMapping("/getForObject")
    public String getForObject(@RequestParam String url) {
        String responseBody = restTemplate.getForObject(url, String.class);

        // Print the response body
        System.out.println("Response Body: " + responseBody);
        return responseBody;
    }

    @GetMapping("/postForEntity")
    public ResponseEntity<String> postForEntity(@RequestParam String url) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class);

        // Get the response status code
        System.out.println("Response Status Code: " + responseEntity.getStatusCode());
        // Get the response body
        String responseBody = responseEntity.getBody();
        System.out.println("Response Body: " + responseBody);
        return responseEntity;
    }

    @GetMapping("/postForObject")
    public String postForObject(@RequestParam String url) {
        String responseBody = restTemplate.postForObject(url, null, String.class);

        // Print the response body
        System.out.println("Response Body: " + responseBody);
        return responseBody;
    }

    @GetMapping("/put")
    public String put(@RequestParam String url) {
        restTemplate.put(url, null);

        // Log the action
        return "PUT request sent to: " ;
    }

    @GetMapping("/headForHeaders")
    public HttpHeaders headForHeaders(@RequestParam String url) {
        HttpHeaders headers = restTemplate.headForHeaders(url);
        // Get the response headers
        System.out.println("Response Headers: " + headers);
        return headers;
    }

    @GetMapping("/optionsForAllow")
    public HttpHeaders optionsForAllow(@RequestParam String url) {
        ResponseEntity<String> responseEntity = (ResponseEntity<String>) restTemplate.optionsForAllow(url);

        // Get the response headers
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println("Response Headers: " + headers);
        return headers;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String url) {
        restTemplate.delete(url);

        // Log the action
        return "DELETE request sent to:" ;
    }
}


