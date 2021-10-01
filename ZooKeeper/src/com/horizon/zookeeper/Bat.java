package com.horizon.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super();
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Wooosh! Flies 30 feet in the air and lands 50 feet away");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("The roof is on fire! Everybody is running!");
		this.energyLevel -= 100;
	}
	
}
