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
 *
 *
 *advantageRuleShouldBeOnPlayer2
 *advantageRuleShouldBeOnPlayer1
 *deuceShouldBeWhenAtLeastMoreThanThreeAndSameScoreForThePlayers
 *
 *
 *playerShouldWinTheSetWhenPlayersHasSixAndLessThanFive
 *playerShouldWinTheSetWhenTheyAreFivePoints
 *
 *
 *automaticTieBreakWhenTheyAreBothSix
 *playerShouldWinInTieBreak
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

    
   /*
    * A partir de l'us 2. ce test n'est plus valable
    *  @Test
    public void gameIsWonAtMoreThanThreePoints() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	nadal.winPoint();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            djoko.winPoint();
        });
        assertThat(game.getScore(), Is.is("Nadal win the game"));
        assertThat(game.getScore(), IsNot.not("Djoko win the game"));
    }*/

    
    @Test
    public void afterAWinGameScoreMustBeReset() {
    	IntStream.rangeClosed(1, 6).forEach((Integer) -> { // 6 points
        	djoko.winAGame();
        });
    	IntStream.rangeClosed(1, 4).forEach((Integer) -> { // 15 -> 30 -> 40 -> point
        	djoko.winPoint();
        });
        assertThat(game.getScore(), Is.is("Djoko win the set")); 
        assertThat(game.getScore(), Is.is("Djoko: 0, Nadal: 0"));
        
    }
    
    
    @Test
    public void advantageRuleShouldBeOnPlayer2() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            djoko.winPoint();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            nadal.winPoint();
        });
        assertThat(game.getScore(), Is.is("Djoko: 40, Nadal: ADV"));
        assertThat(game.getScore(), IsNot.not("Djoko: ADV, Nadal: 0"));
    }
    
    
    @Test
    public void advantageRuleShouldBeOnPlayer1() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            djoko.winPoint();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            nadal.winPoint();
        });
        assertThat(game.getScore(), Is.is("Djoko: ADV, Nadal: 40"));
        assertThat(game.getScore(), IsNot.not("Djoko: 0, Nadal: ADV"));
    }
    

    @Test
    public void deuceShouldBeWhenAtLeastMoreThanThreeAndSameScoreForThePlayers() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            djoko.winPoint();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            nadal.winPoint();
        });
        assertThat(game.getScore(), Is.is("Djoko: DEUCE, Nadal: DEUCE"));
        djoko.winPoint();
        assertThat(game.getScore(), Is.is("Djoko: ADV, Nadal: 40"));
        nadal.winPoint();
        assertThat(game.getScore(), Is.is("Djoko: DEUCE, Nadal: DEUCE"));
        nadal.winPoint();
        assertThat(game.getScore(), Is.is("Djoko: 40, Nadal: ADV"));
        nadal.winPoint();
        assertThat(game.getScore(), Is.is("Nadal wins the 1st game of the set"));
        
    }
    
    
    
    @Test
    public void playerShouldWinTheSetWhenPlayersHasSixAndLessThanFive() {

        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            djoko.winAGame();
            game.addGamePlayed();
        });
        IntStream.rangeClosed(1, 5).forEach((Integer) -> {
            nadal.winAGame();
            game.addGamePlayed();
        }); 
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            nadal.winPoint();
        });
        nadal.winPoint();
        assertThat(game.getScore(), Is.is("Nadal win the set"));
        
    }
    
    @Test
    public void playerShouldWinTheSetWhenTheyAreFivePoints() {

        IntStream.rangeClosed(1, 5).forEach((Integer) -> {
            djoko.winAGame();
            game.addGamePlayed();
        });
        IntStream.rangeClosed(1, 5).forEach((Integer) -> {
            nadal.winAGame();
            game.addGamePlayed();
        }); 

        game.getScore();
        
        IntStream.rangeClosed(1, 1).forEach((Integer) -> {
        	djoko.winAGame();
            game.addGamePlayed();
        }); 
        
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            djoko.winPoint();
        });
               
        assertThat(game.getScore(), Is.is("Djoko win the set"));

        
    }
    

    
    @Test
    public void automaticTieBreakWhenTheyAreBothSix() {

        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            djoko.winAGame();
            game.addGamePlayed();
        });
        
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            nadal.winAGame();
            game.addGamePlayed();
        }); 

        
        djoko.winTieBreakPoint();
               
        assertThat(game.getScore(), Is.is("TB/ Djoko: 1, Nadal: 0"));

        
    }
    
    
    @Test
    public void playerShouldWinInTieBreak() {

        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            djoko.winAGame();
            game.addGamePlayed();
        });
        
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            nadal.winAGame();
            game.addGamePlayed();
        }); 

        
        IntStream.rangeClosed(1, 9).forEach((Integer) -> {
            nadal.winTieBreakPoint();
        }); 
               
        IntStream.rangeClosed(1, 7).forEach((Integer) -> {
        	djoko.winTieBreakPoint();
        }); 
        assertThat(game.getScore(), Is.is("Nadal win the set and the match"));
        
    }

}
