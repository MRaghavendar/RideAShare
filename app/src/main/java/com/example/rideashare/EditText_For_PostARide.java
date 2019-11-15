package com.example.rideashare;

class EditText_For_PostARide {
    private String Starting_Point;
    private String Ending_Point;
    private String Date;
    private String Cost;
    private String Seats_available;
    private String Location;

    public EditText_For_PostARide(String starting_Point, String ending_Point, String date, String cost, String seats_available, String location) {
        Starting_Point = starting_Point;
        Ending_Point = ending_Point;
        Date = date;
        Cost = cost;
        Seats_available = seats_available;
        Location = location;
    }

    public String getStarting_Point() {
        return Starting_Point;
    }

    public void setStarting_Point(String starting_Point) {
        Starting_Point = starting_Point;
    }

    public String getEnding_Point() {
        return Ending_Point;
    }

    public void setEnding_Point(String ending_Point) {
        Ending_Point = ending_Point;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getSeats_available() {
        return Seats_available;
    }

    public void setSeats_available(String seats_available) {
        Seats_available = seats_available;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
