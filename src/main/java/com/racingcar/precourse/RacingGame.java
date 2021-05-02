package com.racingcar.precourse;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private static final int MIN_NAME_LENGTH = 0;
	private static final int MAX_NAME_LENGTH = 5;
	private List<Car> carList;
	
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
