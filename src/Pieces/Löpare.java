package Pieces;

import Blocks.Move;
import Map.Exec;
import javafx.scene.paint.Color;

public class Löpare extends piece{

	public Löpare(int x, int y){
		
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setFill(Color.WHITE);
	}
	int dx = -1;
	int dy = -1;
	
	
	@Override
	public void CheckMoves() {
		Move.DeletMoves();
		LöpareSpecial();
		
		
		
		super.CheckMoves();
	}
	
	private void LöpareSpecial() {
		// TODO Auto-generated method stub

		dy = -1;
		dx = -1;
		
		setMovesRight(this.getY()+dy, this.getX()+dx);
		
		dy = 1;
		dx = 1;
		
		setMovesRight(this.getY()+dy, this.getX()+dx);
		
		dy = -1;
		dx = 1;
		setMovesRight(this.getY()+dy, this.getX()+dx);
		
		dy = 1;
		dx = -1;
		setMovesRight(this.getY()+dy, this.getX()+dx);
	}
	
	/*
	 * +1 +1
	 * -1 -1
	 * +1 -1
	 * -1 +1
	 * 
	 */
	
	private void setMovesRight(int y,int x) {
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
		setMovesRight(y+dy, x+dx);
		
		
	}
	
	
}
