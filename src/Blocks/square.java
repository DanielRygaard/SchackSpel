package Blocks;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class square extends Rectangle{

	
	public static double SIZE = 100;
	public static Paint DARK = Color.DARKGREY;
	public static Paint LIGHT = Color.LIGHTGREY;
	
	
	square(int x, int y, Paint p){
		this.setHeight(square.SIZE);
		this.setWidth(square.SIZE);
		this.setFill(p);
		this.setTranslateX(x*square.SIZE+square.SIZE/2);
		this.setTranslateY(y*square.SIZE+square.SIZE/2);
	}
}
