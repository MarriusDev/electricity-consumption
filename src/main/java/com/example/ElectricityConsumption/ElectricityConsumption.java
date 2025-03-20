package com.example.ElectricityConsumption;

public class ElectricityConsumption {

    private static final int HOURS_IN_DAY = 24;
    private static final int DAYS_IN_WEEK = 7;
    private static final int DAYS_IN_MONTH = 30;  // pro zjednodušení
    private static final int DAYS_IN_YEAR = 365;

    public double getPricePerWh(double pricePerMWh) {
        return pricePerMWh / 1_000_000;
    }

    public double getPricePerHour(double pricePerMWh, double consumption) {
        return consumption * getPricePerWh(pricePerMWh);
    }

    public double getPrice(double pricePerMWh, double consumption, int timePeriodInDays) {
        return consumption * getPricePerWh(pricePerMWh) * timePeriodInDays * HOURS_IN_DAY;
    }

    public String toString(double pricePerMWh, double consumption) {
        return "Za hodinu: " + String.format("%.2f", getPricePerHour(pricePerMWh, consumption)) + "\n" +
                "Za den: " + String.format("%.2f", getPrice(pricePerMWh, consumption, 1)) + "\n" +
                "Za týden: " + String.format("%.2f", getPrice(pricePerMWh, consumption, DAYS_IN_WEEK)) + "\n" +
                "Za měsíc: " + String.format("%.2f", getPrice(pricePerMWh, consumption, DAYS_IN_MONTH)) + "\n" +
                "Za rok: " + String.format("%.2f", getPrice(pricePerMWh, consumption, DAYS_IN_YEAR));
    }

}
