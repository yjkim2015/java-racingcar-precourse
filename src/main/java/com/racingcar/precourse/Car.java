package com.racingcar.precourse;


public class Car {
	private String name;
	private int position;
	
	public Car(String name) {
		this.name = name;
	}
	
	public void canMove(int speed) {
		if ( speed >= 4 ) {
			this.position++;
		}
	}
	
	public String getName() {
		return this.name;
	}
	public int getPosition() {
		return this.position;
	}
	
	public void move(int speed) {
		canMove(speed);
		System.out.print(this.name+":");
		for ( int i = 0; i < this.position; i++ ) {
			System.out.print("-");
		}
		System.out.println("");
	}
}
