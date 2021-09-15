package com.rentalservice;

import com.rentalservice.prices.ChildrensPrice;
import com.rentalservice.prices.NewReleasePrice;
import com.rentalservice.prices.Price;
import com.rentalservice.prices.RegularPrice;

public class Movie {

    private String title;
    private Price price;

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch(priceCode){
            case REGULAR :
                this.price = new RegularPrice();
                break;
            case CHILDREN:
                this.price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code");
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", priceCode=" + price.getPriceCode() +
                '}';
    }

    public int getFrequentRenterPoints(int daysRented){
        return price.getFrequentRenterPoints(daysRented);
    }

    public double getCharge(int daysRented){
        return price.getCharge(daysRented);
    }
}
