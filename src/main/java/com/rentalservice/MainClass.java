package com.rentalservice;

public class MainClass {
    public static void main(String[] args) {
        Movie movie = new Movie("Gladiator", 0);
        Movie movie1 = new Movie("Interstellar", 1);
        Movie movie2 = new Movie("Inception", 2);
        Rental rental = new Rental(movie, 3);
        Rental rental1 = new Rental(movie1, 3);
        Rental rental2 = new Rental(movie2, 6);
        Customer customer = new Customer("Sander");
        customer.addRental(rental);
//        customer.addRental(rental1);
//        customer.addRental(rental2);

        //System.out.println(customer.getRentalList());
        System.out.println(customer.statement());
    }
}
