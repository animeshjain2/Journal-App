package com.example.journalApp.service;

import com.example.journalApp.api.response.WeatherResponse;
import com.example.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String api_key ;


    private String API ;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;
    public WeatherResponse getWeather(String city){
        String finalAPI = appCache.APP_CACHE.get("weather_api").replace("<city>",city).replace("<api_key>",api_key);
//        JSON Object to POJO - deserialization
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = response.getBody();

        return body;


    }



}
