package com.example.used;

public class UsedCarDetails {
    public String carName;
    public String price;
    public String imageUrl;
    public String km;
    public String transmission;
    public String fuel;
    public String cityName;

    public String getFormattedDetails() {
        return km + " | " + transmission + " | " + fuel + " | " + cityName;
    }

    public String getFormattedPrice() {
        return "Rs. " + price;
    }
}
