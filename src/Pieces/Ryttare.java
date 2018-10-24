package Pieces;

import Blocks.Move;
import Map.Board;
import Map.Exec;
import javafx.scene.paint.Color;

public class Ryttare extends piece{

	public Ryttare(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setFill(Color.YELLOW);
	}
	
	
	private void ryttareSpecieal() {
		// TODO Auto-generated method stub

		
		if(this.team == Board.getTeamPlaying()|| 1== 1){
			
			
			
			int dy;
			int dx;
			
			dy = +2;
			dx = +1;
			
			jumpDiag(dy, dx);
			
		
			
			
			
		}
	
		
	}

	
	private void jumpDiag(int dy, int dx) {
		// TODO Auto-generated method stub
		
		dy = 2;
		dx = 1;
		
	
		Move one = null;
		
			int o = 2;
			for(int x = 1; x<=2; x++){
				for(int j = -1; j<=2; j += 2){
					System.out.println(x+" " +o +" " +j);
					
					System.out.println("y+ : "+this.getY()+(x*j) +"\n y- : " );
					if((((this.getY()+(x*j))>=0 &&( this.getY()+(x*j))<8)&&((this.getX()+(o*j))>=0 && (this.getX()+(o*j))<8))){
						if(ifEnemy(this.getY()+(x*j), this.getX()+(o*j))
								||Exec.getBoard().getMapPiece().get(this.getY()+(x*j)).get(this.getX()+(o*j)).getClass().getSimpleName().equals("Nopiece")){
						one = new Move(this.getY()+(x*j), this.getX()+(o*j));
						if(ifEnemy(this.getY()+(x*j), this.getX()+(o*j)))
							one.enemyBlock();
						Move.addMove(one);
						}
					}
					if((((this.getY()-(x*j))>=0 &&( this.getY()-(x*j)<8))&&((this.getX()+(o*j))>=0 && (this.getX()+(o*j))<8))){
						
						if(ifEnemy(this.getY()-(x*j), this.getX()+(o*j))
								||Exec.getBoard().getMapPiece().get(this.getY()-(x*j)).get(this.getX()-(o*j)).getClass().getSimpleName().equals("Nopiece")){
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
	private void jumpHori(int dy, int dx) {
		// TODO Auto-generated method stub
		Move one = null;
		Move two = null;
		
		if(((this.getX()+dx)>=0 && (this.getX()+dx) < 8) && ((this.getY()+dy)>=0 && (this.getY()+dy) < 8))
			if(Exec.getBoard().getMapPiece().get(this.getX()+dx).get(this.getX()+dy).equals("Nopiece")){
			
			}
		
		if(((this.getX()+dx)>=0 && (this.getX()+dx) < 8) && ((this.getY()+dy)>=0 && (this.getY()+dy) < 8))
			if(Exec.getBoard().getMapPiece().get(this.getX()-dx).get(this.getX()+dy).equals("Nopiece")){
			
			}
	}
	
	
	
	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		ryttareSpecieal();
		super.CheckMoves();
	}
	
}
