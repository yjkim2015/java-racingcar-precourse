package com.racingcar.precourse;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author 김윤제
 *
 */
public class CarTest {
	
	@Test
	public void inputCarName() {
		RacingGame racingGame = new RacingGame();
		assertThat(racingGame.createCar("소나타,K5,K7")).isTrue();
		assertThat(racingGame.createCar("펠리세이드, 다섯글자넘는차, 그랜져")).isFalse();
		assertThat(racingGame.createCar("소나타,")).isTrue();
		assertThat(racingGame.createCar("소나타")).isTrue();
	}
}
