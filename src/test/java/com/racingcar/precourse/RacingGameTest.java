package com.racingcar.precourse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
	RacingGame racingGame;
	@BeforeEach
	public void settingTest() {
		racingGame = new RacingGame();
	}
	
	@Test
	public void testIsNumber() {
		assertThat(racingGame.isHighNumberThanZero("0")).isFalse();
		assertThat(racingGame.isHighNumberThanZero("7")).isTrue();
		assertThat(racingGame.isHighNumberThanZero("ad")).isFalse();
		assertThat(racingGame.isHighNumberThanZero("7d")).isFalse();
		assertThat(racingGame.isHighNumberThanZero("a7")).isFalse();
	}
	
	@Test
	public void randomNum() {
		assertThat(racingGame.getRandomNum() > 0).isTrue();
		assertThat(racingGame.getRandomNum() < 10).isTrue();
	}
}
