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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + name + "\n";
        Iterator<Rental> it = rentalList.iterator();
        while (it.hasNext()) {

            Rental each = it.next();

            //determine amounts for each line

            frequentRenterPoints = each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }
        //add Footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }

}
