package Pieces;

import Blocks.Move;
import Map.Board;
import Map.Exec;
import javafx.scene.paint.Color;

public class Knight extends piece{

	public Knight(int y, int x) {
		super(y, x);
		// TODO Auto-generated constructor stub
	}


	
	
	
	private void ryttareSpecieal() {
		// TODO Auto-generated method stub

		
		
			Move.DeletMoves();
			
			
			int dy;
			int dx;
			
			dy = +2;
			dx = +1;
			
			jumpDiag(dy, dx);
			
		
			
			
			
		
	
		
	}

	
	private void jumpDiag(int dy, int dx) {
		// TODO Auto-generated method stub
		
		dy = 2;
		dx = 1;
		
	
		Move one = null;
		
			int o = 2;
			for(int x = 1; x<=2; x++){
				for(int j = -1; j<=2; j += 2){
					
					
					if((((this.getY()+(x*j))>=0 &&( this.getY()+(x*j))<8)&&((this.getX()+(o*j))>=0 && (this.getX()+(o*j))<8))){
						
						if(ifEnemy(this.getY()+(x*j), this.getX()+(o*j))
								||Exec.getBoard().getMapPiece().get((this.getY()+(x*j))).get((this.getX()+(o*j))).getClass().getSimpleName().equals("Nopiece")){
						one = new Move((this.getY()+(x*j)),( this.getX()+(o*j)));
						if(ifEnemy((this.getY()+(x*j)), (this.getX()+(o*j))))
							one.enemyBlock();
						Move.addMove(one);
						}
					}
					if((((this.getY()-(x*j))>=0 &&( this.getY()-(x*j)<8))&&((this.getX()+(o*j))>=0 && (this.getX()+(o*j))<8))){
						
						if(ifEnemy(this.getY()-(x*j), this.getX()+(o*j))
								||Exec.getBoard().getMapPiece().get(this.getY()-(x*j)).get(this.getX()+(o*j)).getClass().getSimpleName().equals("Nopiece")){
							one = new Move(this.getY()-(x*j), this.getX()+(o*j));
							if(ifEnemy(this.getY()-(x*j), this.getX()+(o*j)))
								one.enemyBlock();
							Move.addMove(one);
						}
						
					}
					
					
					
				}
				o--;
				
			}
			
		
			
		
		
	
		
	}
	
	
	
	
	
	@Override
	public void CheckMoves() {
		if(this.team == Board.getTeamPlaying()){
		ryttareSpecieal();
		
		super.CheckMoves();
		}
	}
	
}
