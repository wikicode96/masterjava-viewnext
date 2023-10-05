package com.github.wikicode96.app.model;

import java.util.Objects;
public class Hotel {

    private int id;
    private String name;
    private int category;
    private int fare;
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
