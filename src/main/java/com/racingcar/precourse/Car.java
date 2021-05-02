package com.racingcar.precourse;


public class Car {
	private String name;
	private int position;
	private int speed;
	
	public Car(String name) {
		this.name = name;
	}
	
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}
	
//	public boolean isStart() {
//		boolean result = this.speed >= 4;
//		return result;
//	}
	
	public boolean canMove(int speed) {
		return this.speed >= 4;
	}
	
	public void move() {
		this.position++;
		System.out.print(this.name+":");
		for ( int i = 0; i < this.position; i++ ) {
			System.out.println("-");
		}
	}
}
