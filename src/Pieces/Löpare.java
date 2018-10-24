package Pieces;

import Blocks.Move;
import Map.Board;
import Map.Exec;
import javafx.scene.paint.Color;

public class Löpare extends piece{

	public Löpare(int x, int y){
		
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setFill(Color.WHITE);
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
	
	/*
	 * +1 +1
	 * -1 -1
	 * +1 -1
	 * -1 +1
	 * 
	 */
	
	private void horizontal(int y,int x) {
		// TODO Auto-generated method stub

		if(x>7||x<0||y>7||y<0){
			
			
			return;
			
			
		}
		if(!Exec.board.getPiece(y, x).getClass().getSimpleName().equals("Nopiece")){
			
			if(x < 8 && y< 8 &&Exec.board.getPiece(y, x).team != this.team ){
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
