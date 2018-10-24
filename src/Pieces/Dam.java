package Pieces;

import Blocks.Move;
import Map.Board;
import Map.Exec;
import javafx.scene.paint.Color;

public class Dam extends piece{

	public Dam(int x, int y) {
		super(x, y);
		this.setFill(Color.BLACK);
	}

	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		
		if(this.team == Board.getTeamPlaying()){
			damspecial();
			super.CheckMoves();
		}
	}
	int dy;
	int dx;
	private void damspecial() {
		// TODO Auto-generated method stub

		Move.DeletMoves();
		for (int i = -1; i < 2; i+=2) {
			for (int j = -1; j < 2; j+=2) {
				dy = i;
				dx = j;
				
				
				horizontal(this.getY()+dy, this.getX()+dx);
				
				
			}
		}
		
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
