package com.example.rideashare;

class EditText_For_RequestARide {
    private String StartPoint;
    private String EndPoint;
    private String DateOfRide;
    private String FirebaseID;

    public EditText_For_RequestARide(String startPoint, String endPoint, String dateOfRide, String firebaseID) {
        StartPoint = startPoint;
        EndPoint = endPoint;
        DateOfRide = dateOfRide;
        FirebaseID = firebaseID;
    }

    public String getStartPoint() {
        return StartPoint;
    }

    public String getEndPoint() {
        return EndPoint;
    }

    public String getDateOfRide() {
        return DateOfRide;
    }

    public String getFirebaseID() {
        return FirebaseID;
    }

    public void setStartPoint(String startPoint) {
        StartPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setDateOfRide(String dateOfRide) {
        DateOfRide = dateOfRide;
    }

    public void setFirebaseID(String firebaseID) {
        FirebaseID = firebaseID;
    }
}
