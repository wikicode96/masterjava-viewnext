package com.github.wikicode96.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hotels")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private int category;
    @Column(name = "fare")
    private int fare;
    @Column(name = "available")
    private boolean available;

    public Hotel() {
    }

    public Hotel(int id, String name, int category, int fare, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.fare = fare;
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id && category == hotel.category && fare == hotel.fare && available == hotel.available && Objects.equals(name, hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, fare, available);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
