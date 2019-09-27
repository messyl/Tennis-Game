package main.java.tennis;

/**
 * 
 * @author mesme
 *
 */
public class TennisGame {

	private Player player1;
	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		if (player1.getPoint() > 3 || player2.getPoint() > 3) {
			player1.resetPoint();
			player2.resetPoint();
			return getHighPlayer().getName() + " Win the game";			
		} else {
			return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": "+ player2.getScore();
		}
	}

	public Player getHighPlayer() {
		return (player1.getPoint() > player2.getPoint()) ? player1 : player2;
	}

}
