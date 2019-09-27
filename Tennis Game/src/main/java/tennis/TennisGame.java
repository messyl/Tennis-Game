package main.java.tennis;

/**
 * 
 * @author mesme
 *
 */
public class TennisGame {

	private Player player1;
	private Player player2;
	private Player highPLayer;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		getHighPlayer();
		
		if (player1.getPoint() >= 3 && player2.getPoint() >= 3) {
			if (Math.abs(player2.getPoint() - player1.getPoint()) >= 2) {
				player1.resetPoint();
				player2.resetPoint();
				return highPLayer.getName() + " win the game";
			} else if (player1.getPoint() == player2.getPoint()) {
				return player1.getName()+": DEUCE, "+player2.getName()+": DEUCE";
			} else {
				//qui du joueur 1 ou 2 a l'avantage
				if(highPLayer == player1) {
					return player1.getName()+": ADV" + ", "+player2.getName()+": "+ player2.getScore();
				}else {
					return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": ADV";
				}
			}
		} else if (player1.getPoint()>3 || player2.getPoint()>3) {
			player1.resetPoint();
			player2.resetPoint();
			return highPLayer.getName() + " win the game";
		}
		else {
			return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": "+ player2.getScore();
		}
	}	
	
	
	private void getHighPlayer() {
		if(player1.getPoint() > player2.getPoint())
		{
			highPLayer = player1;
		}else
		{
			highPLayer = player2;
		}
	}

}
