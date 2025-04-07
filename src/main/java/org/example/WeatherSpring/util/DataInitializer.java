package org.example.WeatherSpring.util;

import org.example.WeatherSpring.entity.City;
import org.example.WeatherSpring.repository.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CityRepository cityRepository;

    public DataInitializer(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<City> defaultCities = List.of(
                new City("Moscow", 55.7558, 37.6176),
                new City("London", 51.5074, -0.1278),
                new City("SaintPetersburg", 59.9343, 30.3351),
                new City("Novosibirsk", 55.0084, 82.9357),
                new City("Ekaterinburg", 56.8389, 60.6057),
                new City("Chelyabinsk", 55.1644, 61.4368),
                new City("Omsk", 54.9924, 73.3686)
        );

        defaultCities.forEach(city -> {
            if (!cityRepository.existsByName(city.getName())) {
                cityRepository.save(city);
                System.out.println("Added city: " + city.getName());
            } else {
                System.out.println("City already exists: " + city.getName());
            }
        });

        System.out.println("Cities initialization completed");
    }
}