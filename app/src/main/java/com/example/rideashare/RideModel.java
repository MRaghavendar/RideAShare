package com.example.rideashare;

public class RideModel {
    String id, name, startLoc, EndLoc, dates, price, seats, address;

    public RideModel() {
    }

    public RideModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public RideModel(String id, String name, String startLoc, String endLoc, String dates, String price, String seats, String address) {
        this.id = id;
        this.name = name;
        this.startLoc = startLoc;
        EndLoc = endLoc;
        this.dates = dates;
        this.price = price;
        this.seats = seats;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartLoc() {
        return startLoc;
    }

    public String getEndLoc() {
        return EndLoc;
    }

    public String getDates() {
        return dates;
    }

    public String getPrice() {
        return price;
    }

    public String getSeats() {
        return seats;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartLoc(String startLoc) {
        this.startLoc = startLoc;
    }

    public void setEndLoc(String endLoc) {
        EndLoc = endLoc;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
