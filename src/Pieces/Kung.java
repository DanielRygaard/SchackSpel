package Pieces;

import Blocks.Move;
import Map.Board;
import javafx.scene.paint.Color;

public class Kung extends piece{

	public Kung(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setFill(Color.GOLD);
	}

	
	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		
		if(this.team == Board.getTeamPlaying()){
			kungSpecial();
			super.CheckMoves();
		}
	}
	
	private void kungSpecial() {
		// TODO Auto-generat;ed method stub
		Move.DeletMoves();
		System.out.println("kung");
		for (int x = -1; x<2; x++) {
			for (int y = -1; y < 2; y++) {
					
				
				if(inParameters(this.getX()+x) && inParameters(this.getY()+y)){
					
					if(ifPiece(y, x)){
						if(ifEnemy(this.getY()+y, this.getX()+x)){
							Move enemy = new Move(this.getY()+y, this.getX()+x);
							enemy.enemyBlock();
							Move.addMove(enemy);
						}
					}else{
					Move mov = new Move(this.getY()+y, this.getX()+x);
					Move.addMove(mov);
					}
				}
				
				
				
				
			}
		}
		
		
		
		
	}
	
	
	
	
}
