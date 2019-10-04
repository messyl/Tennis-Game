package main.java.tennis;

public class Set {
	
	private Player leadPointPlayer; //0 - > 40
	private Player leadGamePLayer; //games 0 - > 6 
	private Player leadTieBreakPLayer; // 7 - > (max)
	private int gamesPlayed;
	
	
	public String getSet(Player player1, Player player2) {
		addGamePlayed();
		setLeadGamePlayer(player1, player2);
		leadGamePLayer.winAGame();
		if ( (player1.getGameWon() >= 6 || player2.getGameWon() >= 6) 
				&& Math.abs(player2.getGameWon() - player1.getGameWon()) >= 2) {
			player1.resetGame();
			player2.resetGame();
			resetGamesPlayed();
			return leadGamePLayer.getName() + " win the set"; 
			
		} else if(player1.getGameWon() >= 6 && player1.getGameWon() >= 6) { // Sprint 2 - US2 : Tie Break
			return getTieBreak(player1,player2);
		}
		
		if(gamesPlayed == 1) {
			return leadPointPlayer.getName() + " wins the "+gamesPlayed+"st game of the set";
		}
		return leadPointPlayer.getName() + " wins the "+gamesPlayed+"th game of the set";

	}
	
	public String getTieBreak(Player player1, Player player2) {
		setLeadTieBreakPlayer(player1,player2);
		if ((player2.getTieBreakPoint() >= 7 || player2.getTieBreakPoint() >= 7) && Math.abs(player2.getTieBreakPoint() - player1.getTieBreakPoint()) >= 2) {
			player1.resetTieBreakPoint();
			player2.resetTieBreakPoint();
			return leadTieBreakPLayer.getName() + " win the set and the match"; 
		}else {
			return "TB/ "+player1.getName()+": "+player1.getTieBreakPoint() + ", "+player2.getName()+": "+ player2.getTieBreakPoint();
		}
	}
	
	public void setLeadPointPlayer(Player player1, Player player2) {
		if(player1.getPoint() > player2.getPoint())
		{
			leadPointPlayer = player1;
		}else
		{
			leadPointPlayer = player2;
		}
	}
	
	
	public void setLeadGamePlayer(Player player1, Player player2) {
		if(player1.getGameWon() > player2.getGameWon())
		{
			leadGamePLayer = player1;
		}else
		{
			leadGamePLayer = player2;
		}
	}
	
	
	public void setLeadTieBreakPlayer(Player player1, Player player2) {
		if(player1.getTieBreakPoint() > player2.getTieBreakPoint())
		{
			leadTieBreakPLayer = player1;
		}else
		{
			leadTieBreakPLayer = player2;
		}
	}
	
	public void resetGamesPlayed() {
		gamesPlayed = 0;
	}
	
	public void addGamePlayed() {
		gamesPlayed += 1;
	}
	
	public boolean isPlayer1LeadPoint(Player player1, Player player2) {
		setLeadPointPlayer(player1,player2);
		return player1 == leadPointPlayer ? true : false;
	}
	

}
