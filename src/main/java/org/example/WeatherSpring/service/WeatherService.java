package org.example.WeatherSpring.service;

import lombok.RequiredArgsConstructor;
import org.example.WeatherSpring.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    // Используем текущий Weather API вместо One Call
    @Value("${weather.api.url}")
    private String weatherUrl;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double getTemperature(double lat, double lon) {
        String url = String.format("%s?lat=%f&lon=%f&units=metric&appid=%s",
                weatherUrl, lat, lon, apiKey);

        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response == null || response.getMain() == null) {
            throw new RuntimeException("Invalid weather API response");
        }

        return response.getMain().getTemp();
    }
}
