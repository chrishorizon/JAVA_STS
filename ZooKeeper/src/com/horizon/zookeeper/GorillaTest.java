package com.horizon.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla kong = new Gorilla();
		kong.throwSomething();
		kong.throwSomething();
		kong.throwSomething();
		kong.eatBananas();
		kong.eatBananas();
		kong.climb();
		kong.displayEnergy();
		
		Bat bird = new Bat();
		bird.attackTown();
		bird.attackTown();
		bird.attackTown();
		bird.eatHumans();
		bird.eatHumans();
		bird.fly();
		bird.fly();
		bird.displayEnergy();

	}
	
}
