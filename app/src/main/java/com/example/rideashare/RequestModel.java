package com.example.rideashare;

public class RequestModel {
   String id , name, start, end , date, number;

    public RequestModel(String id, String name, String start, String end, String date, String number) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.date = date;
        this.number = number;
    }

    public RequestModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
