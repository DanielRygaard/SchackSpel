package Pieces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

import Blocks.Move;
import Blocks.square;
import Map.Board;
import Map.Exec;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public abstract class piece extends Circle{
	
	
	double width = square.SIZE/2;
	double height = square.SIZE/2;
	int direction;
	
	/* 
	 * SHows witch team the piece is
	 * 2 = dark
	 * 1 = light
	 */
	public int team = 1;
	
	/**
	 * Is false if the piece has never moved
	 */
	boolean moved = false;
	
	
	/**
	 * x and y coordenets of the element
	 */
	int x;
	int y;

	
	
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	piece(int y, int x){
		
		// Setts upp the look of a piece
		this.setRadius(width/2);
		this.setTranslateX(x*square.SIZE+height);
		this.setTranslateY(y*square.SIZE+width);
		
		// Setts a stroke if the team i light
		if(this.team == 1){
			if(!this.getClass().getSimpleName().equals("Nopiece"))
			this.setStroke(Color.BLACK);
			this.setStrokeWidth(5);
		}else{
			this.setStroke(Color.TRANSPARENT);
		}
		
		//Calls check moves when you click on the element
		this.setOnMouseClicked(e->{
			
			this.CheckMoves();
		});
		
		//Setts X and Y coordenats relative to the sice of each square
		setX((int) ((int)this.getTranslateX()/(square.SIZE)));
		setY((int) (this.getTranslateY()/square.SIZE));
		
		
	}

	/**
	 * Setts the team of a piece
	 * @param team
	 */
	public void setTeam(int team) {
		this.team = team;
		if(this.team == 1){
			if(!this.getClass().getSimpleName().equals("Nopiece"))
			this.setStroke(Color.BLACK);
			this.setStrokeWidth(5);
			this.direction = -1;
		}else{
			this.setStroke(Color.TRANSPARENT);
			this.direction = 1;
		}
		
		
		
	}

	/**
	 * Checks the available moves that this piece has
	 */
	public void CheckMoves() {
		// TODO Auto-generated method stub
		
		
		
	
		
		Exec.board.getChildren().addAll(Move.getMoves());
		
		for(int k = 0; k<Move.getMoves().size(); k++){
			int kx = k;
			
			Move.getMoves().get(k).setOnMouseClicked(e->{
				int gx =  (int) ((int) Move.getMoves().get(kx).getTranslateX()/square.SIZE);
				int gy = (int) ((int)Move.getMoves().get(kx).getTranslateY()/square.SIZE);
				
				this.move(gx, gy);
				setX((int) ((int) Move.getMoves().get(kx).getTranslateX()/square.SIZE));
				setY((int) ((int) Move.getMoves().get(kx).getTranslateY()/square.SIZE));
				Move.DeletMoves();
				Board.nextTurn();
				
			});
		}

		
	}
	
	/**
	 * MOves the element to the x and y coordinates entered
	 * @param x
	 * @param y
	 */
	public void move(int x, int y){
		//If this element moves to where a piece of the other team is, it removes it from the root
		if(this.ifEnemy(y, x)){
			//Kills the enemy piece
			piece.kill(y, x);
		}
		
		//Swaps this piece with the piece that you move to in the arraylist
		getBoard().ArraySwap(this.getY(),this.getX(), y, x);
		
		int number = 0;
		
		if(!ifEnemy((int) ((int) y), (int) ((int) x))){
		number = Exec.getBoard().pieces[(int) ((int) x)][(int) ((int) y)];
		}
		
		Exec.getBoard().pieces[(int) ((int) y)][(int) ((int) x)] = Exec.getBoard().pieces[(int) (this.getTranslateY()/square.SIZE)][(int) (this.getTranslateX()/square.SIZE)];
		Exec.getBoard().pieces[(int) (this.getTranslateY()/square.SIZE)][(int) (this.getTranslateX()/square.SIZE)] = number; 
		
		this.setTranslateX(x*square.SIZE+square.SIZE/2);
		this.setTranslateY(y * square.SIZE+square.SIZE/2);
		
		moved = true; 
		
	}
	// 316  225
	AnimationTimer timer = new AnimationTimer() {
		
		@Override
		public void handle(long now) {
			// TODO Auto-generated method stub
		
			System.out.println();
			System.out.println();
			System.out.println();
			for (int i = 0; i < getBoard().getMapPiece().size(); i++) {
				for (int j = 0; j <  getBoard().getMapPiece().get(i).size(); j++) {
					System.out.print( " " +getBoard().getMapPiece().get(i).get(j).getClass().getSimpleName());
				}
				System.out.println();
			}
			
		}
	};
	
	protected boolean ifEnemy(int y, int x) {
		// TODO Auto-generated method stub
		int you = ((piece) getBoard().getMapPiece().get(this.getY()).get(this.getX())).getTeam();
		int other =  ((piece) getBoard().getMapPiece().get(y).get(x)).getTeam();
	
		//System.out.println(((other != 0) && !(other == you))+" hej");
		if(!(other == 0) && !(other == you)){
			
			return true;
			
		}else{
			
			return false;
		}
			
			
		
		
	}
	
	private int getTeam() {
		// TODO Auto-generated method stub
		return team;
	}

	private Board getBoard() {
		// TODO Auto-generated method stub
		return Exec.board;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	/**
	 * Removes the piece in y and x coordinate from the root
	 */
	public static void kill(int y, int x){
		
		Exec.getBoard().getChildren().remove(Exec.getBoard().getMapPiece().get(y).get(x)); 
		Exec.getBoard().getMapPiece().get(y).set(x, new Nopiece(y,x));
	}
	
	
	
	
	
	
}
