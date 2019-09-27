package main.java.tennis;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author mesme
 *
 */
public class Player {

    private int point;
    
    private String name;
    
    
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
		throw new IllegalArgumentException("Illegal point: " + point);
	}

}
