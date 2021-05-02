package com.racingcar.precourse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

	@Test
	public void testIsNumber() {
		RacingGame racingGame = new RacingGame();
		assertThat(racingGame.isHighNumberThanZero("0")).isFalse();
		assertThat(racingGame.isHighNumberThanZero("7")).isTrue();
		assertThat(racingGame.isHighNumberThanZero("ad")).isFalse();
		assertThat(racingGame.isHighNumberThanZero("7d")).isFalse();
		assertThat(racingGame.isHighNumberThanZero("a7")).isFalse();
	}
}
