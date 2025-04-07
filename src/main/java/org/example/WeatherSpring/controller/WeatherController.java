package org.example.WeatherSpring.controller;

import org.example.WeatherSpring.service.CityWeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final CityWeatherService cityWeatherService;

    public WeatherController(CityWeatherService cityWeatherService) {
        this.cityWeatherService = cityWeatherService;
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<?> getWeather(@PathVariable String cityName) {
        try {
            double temperature = cityWeatherService.getTemperatureByCityName(cityName);
            return ResponseEntity.ok(temperature);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error getting weather: " + e.getMessage());
        }
    }
}