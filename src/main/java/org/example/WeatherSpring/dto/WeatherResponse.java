package org.example.WeatherSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherResponse {
    // Геттеры и сеттеры
    private Main main;

    @Setter
    @Getter
    public static class Main {
        // Геттеры и сеттеры
        private double temp;

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }

}
