package com.example.rideashare;

public class Details {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String Email;
    private String id ;
    private String password;

    public Details(){

    }

    public Details(String id,String first_name, String last_name, String phone_number, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        Email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
