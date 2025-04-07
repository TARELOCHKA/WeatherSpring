package org.example.WeatherSpring.service;

import lombok.RequiredArgsConstructor;
import org.example.WeatherSpring.entity.City;
import org.example.WeatherSpring.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityWeatherService {
    private final CityRepository cityRepository;
    private final WeatherService weatherService;

    public double getTemperatureByCityName(String cityName) {
        City city = cityRepository.findByName(cityName)
                .orElseThrow(() -> new RuntimeException("City not found"));

        return weatherService.getTemperature(city.getLatitude(), city.getLongitude());
    }
}
