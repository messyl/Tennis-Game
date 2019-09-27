package test.java.tennis;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import main.java.tennis.Player;
import main.java.tennis.TennisGame;

/**
 * 
 * @author mesme
 * 
 * TEST TENNIS GAME
 * 
 ***Rules***
 *
 * The game starts with a score of 0 point for each player
 * Each time a player win a point, the Game score changes as follow:
 * 0 -> 15 -> 30 -> 40-> Win game
 *
 *
 *
 *theScoreShouldStartAtZero0
 *fifteenShouldBeForScore1
 *thirtyShouldForScore2
 *fortyShouldBeForScore3
 *gameIsWonAtMoreThanThreePoints
 */
public class TennisGameTest {
	
    Player djoko;
    Player nadal;
    TennisGame game;

    @Before
    public void beforeGameTest() {
        djoko = new Player("Djoko");
        nadal = new Player("Nadal");
        game  = new TennisGame(djoko, nadal);
    }

    @Test
    public void theScoreShouldStartAtZero0() {
        TennisGame game = new TennisGame(djoko, nadal);
        assertThat(game.getScore(), Is.is("Djoko: 0, Nadal: 0"));
    }
    

    @Test
    public void fifteenShouldBeForScore1() {
        djoko.winPoint();
        assertThat(game.getScore(), Is.is("Djoko: 15, Nadal: 0"));
    }

    @Test
    public void thirtyShouldForScore2() {
        nadal.winPoint();
        djoko.winPoint();
        nadal.winPoint();
        assertThat(game.getScore(), Is.is("Djoko: 15, Nadal: 30"));
    }

    @Test
    public void fortyShouldBeForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
                djoko.winPoint();
        });
        assertThat(game.getScore(), Is.is("Djoko: 40, Nadal: 0"));
    }

    
    @Test
    public void gameIsWonAtMoreThanThreePoints() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	nadal.winPoint();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            djoko.winPoint();
        });
        assertThat(game.getScore(), Is.is("Nadal Win the game"));
        assertThat(game.getScore(), IsNot.not("Djoko Win the game"));
    }

}
