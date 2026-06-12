package com.edigest.test1.Service;

import com.edigest.test1.api.response.WeatherResponse;
import com.edigest.test1.cache.Appcache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherservice {

    @Value("${weather.api.key}")
    private String apiKey ;

//    private static final String API = "http://api.weatherstack.com/current?access_key=%s&query=%s";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Appcache appcache;

    public WeatherResponse getWeather(String city){
//        String finalAPI = String.format(API,apiKey, city);
String finalAPI = appcache.APP_CACHE.get("weather_api").replace("CITY",city).replace("API_KEY",apiKey);
        ResponseEntity<WeatherResponse> response =
                restTemplate.exchange(
                        finalAPI,
                        HttpMethod.GET,
                        null,
                        WeatherResponse.class
                );
     WeatherResponse body = response.getBody();
     return body;
    }
}
