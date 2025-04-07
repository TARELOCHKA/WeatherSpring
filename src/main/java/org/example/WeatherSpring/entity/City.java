package org.example.WeatherSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "locations", uniqueConstraints = @UniqueConstraint(columnNames = "name")) // если ваша таблица называется locations
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID будет генерироваться автоматически

    @Column(nullable = false, unique = true)
    private String name;

    private double latitude;
    private double longitude;

    // Конструктор без аргументов (обязателен для JPA)
    public City() {
    }

    // Конструктор с параметрами (без ID)
    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
