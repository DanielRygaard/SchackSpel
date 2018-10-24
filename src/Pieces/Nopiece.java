package Pieces;

import javafx.scene.paint.Color;

public class Nopiece extends piece{

	public Nopiece(int x, int y) {
		
		
		
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setFill(Color.TRANSPARENT);
		this.setRadius(0);
	    this.team = 0;
	}

}
