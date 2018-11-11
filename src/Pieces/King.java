package Pieces;

import Blocks.Move;
import Blocks.square;
import Map.Board;
import Map.Exec;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class King extends piece{

	public King(int y, int x) {
		super(y, x);
		// TODO Auto-generated constructor stub
		
	}



	

	
	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		
		if(this.team == Board.getTeamPlaying()){
			kungSpecial();
			super.CheckMoves();
		}
	}
	int dx;
	int dy;
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
	
	private void horizontal(int y,int x, String spiece) {
		// TODO Auto-generated method stub

		if(this.inParameters(y)){
			
			
			return;
			
			
		}
		if(!Exec.board.getMapPiece().get(y).get(x).getClass().getSimpleName().equals("Nopiece")){
			
			if(this.inParameters(x)&& this.inParameters(y)&&Exec.board.getMapPiece().get(y).get(x).getClass().getSimpleName().equals(spiece) ){
				Rectangle enemy = new Rectangle(y, x, square.SIZE, square.SIZE);
				enemy.setFill(Color.RED);
				Exec.getBoard().getChildren().add(enemy);
			}
			
			return;
			
		}
		
		horizontal(y+dy, x+dx, spiece);
		
		
	}
	public void checkSchack(){
		for (int i = -1; i < 2; i+=2) {
			for (int j = -1; j < 2; j+=2) {
				dy = i;
				dx = j;
				
				
				horizontal(this.getY()+dy, this.getX()+dx, "Bishop");
				
				
			}
		}
	}
	
	AnimationTimer timer = new AnimationTimer() {
		
		@Override
		public void handle(long now) {
			// TODO Auto-generated method stub
			checkSchack();
			
		}
	};
	
	
	
}
