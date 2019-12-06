package com.example.rideashare;

class PostedRide {
    private String start;
    private String end;
    private String Date_time;
    private String price;
    private String seats;
    private String place;


    public PostedRide(String start, String end, String Date_time, String price, String seats, String place) {

        this.start = start;
        this.end = end;
        this.Date_time = Date_time;
        this.price = price;
        this.seats = seats;
        this.place = place;

    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDate_time() {
        return Date_time;
    }

    public void setDate_time(String date_time) {
        Date_time = date_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
