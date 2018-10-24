package Blocks;

import java.util.ArrayList;

import Map.Board;
import Map.Exec;
import Pieces.pawn;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Move extends Rectangle{

	static int x;
	static int y;
	private static ArrayList<Move> moves = new ArrayList<Move>();
	public Move(int y, int x){
		this.setWidth(square.SIZE);
		this.setHeight(square.SIZE);
		this.setFill(Color.BLACK);
		
		this.setTranslateX(x*square.SIZE);
		this.setTranslateY((y*square.SIZE));
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
