package Pieces;


import java.util.ArrayList;

import com.sun.javafx.geom.Rectangle;

import Blocks.Move;
import Blocks.square;
import Map.Board;
import Map.Exec;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class pawn extends piece{

	
	
	
	
	
	public pawn(int x, int y) {
		super(x, y);
		this.setFill(Color.GREEN);
		
	}

	
	private void pawnSpecieal() {
		// TODO Auto-generated method stub
		Move.DeletMoves();
		
		
		if(this.team == 1){
			this.direction = 1;
		}else{
			this.direction = -1;
		}
		
		if(!moved && team == Board.getTeamPlaying()&& (Exec.getBoard().getPiece(this.getY()+1*direction, this.getX()).getClass().getSimpleName().equals("Nopiece"))){
			
			
			Move second = new Move(this.getY()+(2* this.direction), this.getX());
			
			Move.addMove(second);
			
			int hej = Exec.getBoard().pieces[(int) ((int) x)][(int) ((int) y)];
		}
		if(team == Board.getTeamPlaying()){
			if(this.getY()+1*direction < 8 && this.getX()+1*direction <8 &&this.getY()+1*direction > 0 && this.getX()+1*direction >0)
			
				
				if(ifEnemy(this.getY()+1*direction, this.getX()+1*direction)){
				
				Move left = null;
				 left = new Move(this.getY()+(1*this.direction), this.getX()+(1*direction));
				 left.enemyBlock();
				 Move.addMove(left);
			}
				
			if(this.getY()+1*direction < 8 && this.getX()-1*direction <8 &&this.getY()+1*direction > 0 && this.getX()-1*direction >0)
			if(ifEnemy(this.getY()+1*direction, this.getX()-1*direction)){
				Move right = null;
				right = new Move(this.getY()+(1*this.direction), this.getX()-(1*direction));
				right.enemyBlock();
				Move.addMove(right);
			}
		
			
		}
		if(team == Board.getTeamPlaying()&& (Exec.getBoard().getPiece(this.getY()+1*direction, this.getX()).getClass().getSimpleName().equals("Nopiece"))){
			Move first = new Move(this.getY()+(1* this.direction), this.getX());
			
			Move.addMove(first);
		}
		
	}
	public boolean showing = false;

	
	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		
		
		
		pawnSpecieal();
		
		super.CheckMoves();
		
		
		
			
			
		}
	
	
	
	

	
}
