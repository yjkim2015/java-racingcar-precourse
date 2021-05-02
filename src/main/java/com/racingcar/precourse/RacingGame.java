package com.racingcar.precourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private static final int MIN_NAME_LENGTH = 0;
	private static final int MAX_NAME_LENGTH = 5;
	private List<Car> carList;
	private int moveCount;
	
	public void ready() {
		inputCarName();
		inputMoveCount();
		start();
	}
	
	public void start() {
	
	}
	
	public boolean isHighNumberThanZero(String inputNum) {
		try {
			return Integer.parseInt(inputNum) > 0 ? true : false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void inputCarName() {
		Scanner sc = new Scanner(System.in);
		String carsName = sc.next();
		while ( createCar(carsName) ) {
			carsName = sc.next();
		}
	}
	
	public void inputMoveCount() {
		Scanner sc = new Scanner(System.in);
		String count = sc.next();
		while ( isHighNumberThanZero(count) ) {
			moveCount = Integer.parseInt(count);
		}
	}
	
	
	public boolean createCar(String carsName) {
		carList = new ArrayList<>();;
		String[] splitCarNames = carsName.split(",");
		for ( String oneCar : splitCarNames ) {
			processCreateCar(oneCar);
		}
		return carList.size() == splitCarNames.length;
	}
	
	public void processCreateCar(String oneCar) {
		if ( canCreateCar(oneCar) ) {
			carList.add(new Car(oneCar));
		}
	}
	
	public boolean canCreateCar(String oneCar) {
		return oneCar.trim().length() > MIN_NAME_LENGTH && oneCar.trim().length() <= MAX_NAME_LENGTH ;
	}
}
