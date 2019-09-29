package main.java.tennis;

/**
 * 
 * @author mesme
 *
 */
public class TennisGame {

	private Player player1;
	private Player player2;
	private Player leadPointPlayer;
	private Player leadGamePLayer;
	private Player leadTieBreakPLayer;
	private int gamesPlayed;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		getLeadPointPlayer();
		if (player1.getPoint() >= 3 && player2.getPoint() >= 3) {
			if (Math.abs(player2.getPoint() - player1.getPoint()) >= 2) {
				player1.resetPoint();
				player2.resetPoint();
				//Spint2 - US1 the player win
				return getSet();
			} else if (player1.getPoint() == player2.getPoint()) {
				return player1.getName()+": DEUCE, "+player2.getName()+": DEUCE";
			} else {
				//qui du joueur 1 ou 2 a l'avantage
				if(leadPointPlayer == player1) {
					return player1.getName()+": ADV" + ", "+player2.getName()+": "+ player2.getScore();
				}else {
					return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": ADV";
				}
			}
		} else if (player1.getPoint()>3 || player2.getPoint()>3) {
			player1.resetPoint();
			player2.resetPoint();
			//Spint2 - US1 the player win
			return getSet();
		} else if (player1.getGameWon() == 6 && player2.getGameWon() == 6) {
			player1.resetPoint();
			player2.resetPoint();
			return getTieBreak();
		}
		else {
			return player1.getName()+": "+player1.getScore() + ", "+player2.getName()+": "+ player2.getScore();
		}
	}	
	
	public String getSet() {
		addGamePlayed();
		getLeadGamePlayer();
		leadGamePLayer.winAGame();
		if(player1.getGameWon() >= 7 || player2.getGameWon() >= 7) {
			player1.resetGame();
			player2.resetGame();
			resetGamesPlayed();
			return leadGamePLayer.getName() + " win the set"; 
		} else if ( (player1.getGameWon() == 6 && player2.getGameWon() <= 4) || (player1.getGameWon() <= 4 && player2.getGameWon() == 6) ) {
			player1.resetGame();
			player2.resetGame();
			resetGamesPlayed();
			return leadGamePLayer.getName() + " win the set"; 
			
		} else if(player1.getGameWon() >= 6 && player1.getGameWon() >= 6) { // Sprint 2 - US2 : Tie Break
			return getTieBreak();
		}
		
		if(gamesPlayed == 1) {
			return leadPointPlayer.getName() + " wins the "+gamesPlayed+"st game of the set";
		}
		return leadPointPlayer.getName() + " wins the "+gamesPlayed+"th game of the set";

	}
	
	
	public String getTieBreak() {
		getLeadTieBreakPlayer();
		if ((player2.getTieBreakPoint() >= 7 || player2.getTieBreakPoint() >= 7) && Math.abs(player2.getTieBreakPoint() - player1.getTieBreakPoint()) >= 2) {
			player1.resetTieBreakPoint();
			player2.resetTieBreakPoint();
			return leadTieBreakPLayer.getName() + " win the set and the match"; 
		}else {
			return "TB/ "+player1.getName()+": "+player1.getTieBreakPoint() + ", "+player2.getName()+": "+ player2.getTieBreakPoint();
		}
	}
	
	
	public void resetGamesPlayed() {
		gamesPlayed = 0;
	}
	
	public void addGamePlayed() {
		gamesPlayed += 1;
	}

	private void getLeadPointPlayer() {
		if(player1.getPoint() > player2.getPoint())
		{
			leadPointPlayer = player1;
		}else
		{
			leadPointPlayer = player2;
		}
	}
	
	
	private void getLeadGamePlayer() {
		if(player1.getGameWon() > player2.getGameWon())
		{
			leadGamePLayer = player1;
		}else
		{
			leadGamePLayer = player2;
		}
	}
	
	
	private void getLeadTieBreakPlayer() {
		if(player1.getTieBreakPoint() > player2.getTieBreakPoint())
		{
			leadTieBreakPLayer = player1;
		}else
		{
			leadTieBreakPLayer = player2;
		}
	}

}
