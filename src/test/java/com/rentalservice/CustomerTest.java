package com.rentalservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CustomerTest {


    @Test
    public void testGetName(){
        Customer customer = new Customer("Sander");
        Assertions.assertThat(customer.getName()).isEqualTo("Sander");
    }

    @Test
    public void statementMethodOf1Rental(){
        Customer customer = new Customer("Sander");
        Movie movie = new Movie("Gladiator", 0);
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);
        Assertions.assertThat(customer.statement()).isEqualTo("""
                Rental Record for Sander
                \tGladiator\t3.5
                Amount owed is 3.5
                You earned 1 frequent renter points.""");
    }

    @Test
    public void statementMethodOf2Rentals(){
        Customer customer = new Customer("Sander");
        Movie movie1 = new Movie("Gladiator", 0);
        Movie movie2 = new Movie("Inception", 1);
        Rental rental1 = new Rental(movie1, 3);
        Rental rental2 = new Rental(movie2, 1);
        customer.addRental(rental1);
        customer.addRental(rental2);
        Assertions.assertThat(customer.statement()).isEqualTo("""
                Rental Record for Sander
                \tGladiator\t3.5
                \tInception\t3.0
                Amount owed is 6.5
                You earned 2 frequent renter points.""");
    }




}
