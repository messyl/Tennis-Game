package main.java.tennis;

/**
 * 
 * @author mesme
 *
 */
public class TennisGame {

	private Player player1;
	private Player player2;
	private Set set;

	
	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		set = new Set();
	}
	

	public String getScore() {
		set.setLeadPointPlayer(player1,player2);
		if (player1.getPoint() >= 3 && player2.getPoint() >= 3) {
			if (Math.abs(player2.getPoint() - player1.getPoint()) >= 2) {
				player1.resetPoint();
				player2.resetPoint();
				//Spint2 - US1 the player win
				return set.getSet(player1,player2);
			} else if (player1.getPoint() == player2.getPoint()) {
				return player1.getName()+": DEUCE, "+player2.getName()+": DEUCE";
			} else {
				//qui du joueur 1 ou 2 a l'avantage
				if(set.isPlayer1LeadPoint(player1,player2)) {
					return player1.getName()+": ADV" + ", "+player2.getName()+": "+ player2.getScore();
				}else {
					return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": ADV";
				}
			}
		} else if (player1.getPoint()>3 || player2.getPoint()>3) { //Set Rule
			player1.resetPoint();
			player2.resetPoint();
			//Spint2 - US1 the player win
			return set.getSet(player1,player2);
		} else if (player1.getGameWon() == 6 && player2.getGameWon() == 6) {   //Tie Break rule
			player1.resetPoint();
			player2.resetPoint();
			return set.getTieBreak(player1,player2);
		}
		else {
			return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": "+ player2.getScore();
		}
	}	
	
	public Set getSet() {
		return this.set;
	}
}
