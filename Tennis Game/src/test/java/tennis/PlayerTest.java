package test.java.tennis;

import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import org.hamcrest.core.Is;
import org.junit.Test;

import main.java.tennis.Player;

/**
 * 
 * @author mesme
 * 
 * TEST PLAYER
 * 
 ***Rules***
 *
 * A player can win points
 * 
 * playerCanWinPoints
 */
public class PlayerTest {

	@Test
	public void playerCanWinPoints() {
		Player djoko = new Player("Djoko");
		Player nadal = new Player("Nadal");

		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			djoko.winPoint();
		});

		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			nadal.winPoint();
		});

		// test
		assertThat(djoko.getPoint(), Is.is(3));
		assertThat(nadal.getPoint(), Is.is(4));
	}

}
