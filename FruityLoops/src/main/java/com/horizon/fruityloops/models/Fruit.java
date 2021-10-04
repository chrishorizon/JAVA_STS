package com.horizon.fruityloops.models;

public class Fruit {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    
    // CONSTRUCTOR
    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}    
    
}
