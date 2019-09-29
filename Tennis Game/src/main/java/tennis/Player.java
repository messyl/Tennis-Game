package main.java.tennis;


/**
 * 
 * @author mesme
 *
 */
public class Player {

    private int point;
    
    private String name;
    
    private int gameWon;
    
    private int tieBreakPoint;
    
    
    /**
     * Constructor
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }
    
      
    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
    
    public void winPoint() {
    	this.point +=  1;
    }

    public void resetPoint() {
		this.point = 0;
	}
    
    
    public int getGameWon() {
		return gameWon;
	}

	public void winAGame() {
        this.gameWon +=  1;
    }

    public void resetGame() {
		this.gameWon = 0;
	}

	public int getScore() {
		switch (point) {
		case 3:
			return 40;
		case 2:
			return 30;
		case 1: 
			return 15;
		case 0:
			return  0;
		}
		return 40;
	}
	
	
	
    public int getTieBreakPoint() {
        return tieBreakPoint;
    }
    
    public void winTieBreakPoint() {
    	this.tieBreakPoint +=  1;
    }

    public void resetTieBreakPoint() {
		this.tieBreakPoint = 0;
	}

}
