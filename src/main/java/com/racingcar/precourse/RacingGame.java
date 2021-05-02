package com.racingcar.precourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
	private static final int MIN_NAME_LENGTH = 0;
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MAX_NUM = 10;

	private List<Car> carList;
	private int moveCount;
	
	public void ready() {
		inputCarName();
		inputMoveCount();
		start();
	}
	
	public void start() {
		System.out.println("실행 결과");
		for ( int i = 0 ; i < moveCount; i++ ) {
			startCar();
		}
		judgeMentGame();
	}
	
	public void startCar() {
		for ( int i = 0; i < carList.size(); i++ ) {
			carList.get(i).move(getRandomNum());
		}
		System.out.println("");
	}
	
	public void inputCarName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carsName = sc.next();
		while ( !createCar(carsName) ) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carsName = sc.next();
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
	
	public void inputMoveCount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		String count = sc.next();
		while ( !isHighNumberThanZero(count) ) {
			System.out.println("시도할 회수는 몇회인가요?");
		}
	}
	
	public boolean isHighNumberThanZero(String inputNum) {
		try {
			moveCount = Integer.parseInt(inputNum);
			if ( moveCount > 0 ) return true;
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public int getRandomNum() {
		Random random = new Random();
		return random.nextInt(MAX_NUM);
	}
	
	public void judgeMentGame() {
		List<Integer> carIndexes = new ArrayList<>();
		for ( int i = 0; i < carList.size(); i++ ) {
			carIndexes = processGetMaxPositionIndexes(carIndexes, carList.get(i), i);
		}
		StringBuffer sb = new StringBuffer();
		List<String> winnerList = new ArrayList<>();
		for ( Integer one : carIndexes ) {
			winnerList.add(carList.get(one).getName());
		}
		sb.append(String.join(", ", winnerList));
		System.out.println(sb.toString()+"가 최종 우승했습니다.");
	}
	
	public List<Integer> processGetMaxPositionIndexes(List<Integer> carIndexes, Car oneCar, int carIndex) {
		if ( carIndexes.size() == 0 ) {
			carIndexes.add(carIndex);
		}
		else if ( carIndexes.size() > 0 ) {
			if ( carList.get(carIndexes.get(0)).getPosition() < oneCar.getPosition() ) {
				carIndexes.clear();
				carIndexes.add(carIndex);
			}
			else if ( carList.get(carIndexes.get(0)).getPosition() == oneCar.getPosition() ){
				carIndexes.add(carIndex);
			}
		}
		return carIndexes;
	}
}
