package com.horizon.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("Gorilla threw a stick!");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla eats a banana to recover energy");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla climbs tree");
		this.energyLevel -= 10;
	}
	
}
