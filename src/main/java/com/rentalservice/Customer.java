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
            double thisAmount = 0;
            Rental each = it.next();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                        break;
                    }
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                        break;
                    }
            }

            //add Frequent Renterpoints
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add Footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }
}
