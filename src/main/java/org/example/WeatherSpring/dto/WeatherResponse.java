package org.example.WeatherSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherResponse {
    private Main main;

    @Setter
    @Getter
    public static class Main {
        private double temp;
    }

}
