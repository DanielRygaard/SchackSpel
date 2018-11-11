package Blocks;

import java.util.ArrayList;

import Map.Board;
import Map.Exec;
import Pieces.Pawn;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Move extends Circle{

	static int x;
	static int y;
	private static ArrayList<Move> moves = new ArrayList<Move>();
	public Move(int y, int x){
		this.setRadius(square.SIZE/4);
		
		this.setFill(Color.GREY);
		
		this.setTranslateX(x*square.SIZE +square.SIZE/2);
		this.setTranslateY((y*square.SIZE + square.SIZE/2));
		this.x = x;
		this.y = y;
	}
	public static void DeletMoves() {
		// TODO Auto-generated method stub

		Exec.board.getChildren().removeAll(moves);
		moves.clear();
		
		
	}
	
	public static void addMove(Move move){
		
		if(!moves.contains(move)){
			
			
				
			
			moves.add(move);
		}
	}
	public static ArrayList<Move> getMoves() {
		return moves;
	}
	public void enemyBlock() {
		// TODO Auto-generated method stub
		this.setFill(Color.RED);
		this.setOpacity(0.5);
	}
}
