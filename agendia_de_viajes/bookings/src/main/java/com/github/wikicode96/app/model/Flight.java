package com.github.wikicode96.app.model;

import java.sql.Date;

public class Flight {

    private int id;
    private String company;
    private Date date;
    private int price;
    private int seats;

    public Flight() {
    }

    public Flight(int id, String company, Date date, int price, int seats) {
        this.id = id;
        this.company = company;
        this.date = date;
        this.price = price;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
