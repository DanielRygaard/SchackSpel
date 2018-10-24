package Pieces;

import Blocks.Move;
import Map.Board;
import javafx.scene.paint.Color;

public class Torn extends piece{

	public Torn(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setFill(Color.BLUE);
		
		
	}
	
	
	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		if(this.team == Board.getTeamPlaying()){
			TornSpecial();
			super.CheckMoves();
		}
	}
	int dy;
	int dx;
	
	
	private void TornSpecial() {
		// TODO Auto-generated method stub
		Move.DeletMoves();
		for (int i = 0; i < 2; i++) {
			
			for (int j = -1; j < 2; j+=2) {
				int k = -1;
				if(j <0){
					k = 1;
				}
				
				
				dy = (i*k);
				dx = (j +(i*k));
				
				
				alltheway(dy,dx);
			}
		}
		
		
		
		
		
		
	}
	
	
	private void alltheway(int dy, int dx) {
		
		
		if(!inParameters((this.getY()+dy)) || !inParameters(this.getX()+dx)){
			return;
		}
	
		if(ifPiece(dy, dx)){
			if(ifEnemy(this.getY()+dy, this.getX()+dx)){
				Move enemy = new Move(this.getY()+dy, this.getX()+dx);
				enemy.enemyBlock();
				Move.addMove(enemy);
				return;
			}
			return;
		}
		
		Move mov = new Move(this.getY()+dy, this.getX()+dx);
		Move.addMove(mov);
		
		alltheway(this.dy+dy,this.dx+dx);
		
		
		
		
		
	}

	
	
}
