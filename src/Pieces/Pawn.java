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

public class Pawn extends piece{

	
	
	
	
	
	public Pawn(int x, int y) {
		super(x, y);
		
		
	}

	
	private void pawnSpecieal() {
		// TODO Auto-generated method stub
		
		Move.DeletMoves();
		
		if(this.team == 1){
			this.direction = 1;
		}else{
			this.direction = -1;
		}
		Move.DeletMoves();
		if(!moved && (Exec.getBoard().getPiece(this.getY()+2*direction, this.getX()).getClass().getSimpleName().equals("Nopiece"))){
			
			
			Move second = new Move(this.getY()+(2* this.direction), this.getX());
			
			Move.addMove(second);
			
		
		}
		
		if(this.inParameters(this.getY()) && this.inParameters(this.getX()))
			
				
			if(ifEnemy(this.getY()+1*direction, this.getX()+1*direction)){
				
				Move left = null;
				 left = new Move(this.getY()+(1*this.direction), this.getX()+(1*direction));
				 left.enemyBlock();
				 Move.addMove(left);
			}
				
			if(ifEnemy(this.getY()+1*direction, this.getX()-1*direction)){
				Move right = null;
				right = new Move(this.getY()+(1*this.direction), this.getX()-(1*direction));
				right.enemyBlock();
				Move.addMove(right);
			}
		
			
		
		if( (Exec.getBoard().getPiece(this.getY()+1*direction, this.getX()).getClass().getSimpleName().equals("Nopiece"))){
			Move first = new Move(this.getY()+(1* this.direction), this.getX());
			
			Move.addMove(first);
		}
		
	}
	public boolean showing = false;

	
	
	@Override
	public void CheckMoves() {
		// TODO Auto-generated method stub
		
		
		if(this.team == Board.getTeamPlaying()){
			pawnSpecieal();
			super.CheckMoves();
		}
		
		
			
			
		}
	
	
	
	

	
}
