package com.rentalservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentalList;

    public Customer(String name) {
        this.name = name;
        this.rentalList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public String statement() {
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentalList) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        //add Footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        for (Rental rental : rentalList          ) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentalList          ) {
            result += rental.getCharge();
        }
        return result;
    }

}
