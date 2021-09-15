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
    public void testStatementMethod(){
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


}
