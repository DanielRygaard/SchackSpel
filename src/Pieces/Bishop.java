package Pieces;

import Blocks.Move;
import Map.Board;
import Map.Exec;
import javafx.scene.paint.Color;

public class Bishop extends piece{

	public Bishop(int y, int x) {
		super(y, x);
		// TODO Auto-generated constructor stub
	}



	
	
	@Override
	public void CheckMoves() {
		
		
		if(this.team == Board.getTeamPlaying()){
			LöpareSpecial();
			super.CheckMoves();
		}
	}
	
	int dx;
	int dy;
	private void LöpareSpecial() {
		// TODO Auto-generated method stub
		Move.DeletMoves();
		for (int i = -1; i < 2; i+=2) {
			for (int j = -1; j < 2; j+=2) {
				dy = i;
				dx = j;
				
				
				horizontal(this.getY()+dy, this.getX()+dx);
				
				
			}
		}
		
		
	}
	
	
	
	private void horizontal(int y,int x) {
		// TODO Auto-generated method stub

		if(!this.inParameters(y)|| !this.inParameters(x)){
			
			
			return;
			
			
		}
		if(!Exec.board.getMapPiece().get(y).get(x).getClass().getSimpleName().equals("Nopiece")){
			
			if(this.inParameters(x)&& this.inParameters(y)&&Exec.board.getMapPiece().get(y).get(x).getClass().getSimpleName().equals("Nopiece") ){
				Move enemy = new Move(y, x);
				enemy.enemyBlock();
				Move.addMove(enemy);
			}
			
			return;
			
		}
		Move move = new Move(y, x);
		Move.addMove(move);
		horizontal(y+dy, x+dx);
		
		
	}
	
	
}
