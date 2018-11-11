package Map;
import java.util.ArrayList;

import Blocks.DarkSquare;
import Blocks.LightSquare;
import Blocks.Move;
import Blocks.square;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Nopiece;
import Pieces.Queen;
import Pieces.Rook;
import Pieces.Pawn;
import Pieces.piece;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Board extends Group{


	/*
	 * 0. inget
	 * 1.Bonde
	 * 2.Löpare
	 * 3.Ryttare
	 * 4.Torn
	 * 5.Kung
	 * 6.Dam
	 */
	
	public static boolean shaack = false;
	
	
	double width = Exec.width;
	double height = Exec.height;
	public int[][] pieces =
		{  
		{14,13,12,15,16,12,13,14},
		{11,11,11,11,11,11,11,11},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{21,21,21,21,21,21,21,21},
		{24,23,22,25,26,22,23,24}
		};
	
	static Text who = new Text();
	
	ArrayList<ArrayList<Node>> MapPiece = new ArrayList<ArrayList<Node>>();
	ArrayList<ArrayList<Node>> MapSquare = new ArrayList<ArrayList<Node>>();
	static int teamPlaying = 2;
	public Board(){
		
		
		

		Rectangle sqare = null;
		
		// Fill board with squares
		for(int y = 0; y*square.SIZE < square.SIZE*8; y++){
			
			ArrayList<Node> row = new ArrayList<Node>();
			for(int x= 0; x*square.SIZE < square.SIZE*8; x++){
				if((x == 0 || (x%2) == 0) && (y%2) == 0){
				   sqare = new LightSquare();
					
				}else if((y%2) == 0){
					
					sqare = new DarkSquare();
					
				}else if((x == 0 || (x%2) == 0) && (y%2) != 0){
					sqare = new DarkSquare();
				}else{
					sqare = new LightSquare();
				}
				
				sqare.setTranslateX(x*square.SIZE);
				sqare.setTranslateY(y *square.SIZE);
				row.add(sqare);
				this.getChildren().add(sqare);
			}
			MapSquare.add(row);
		}
		
		Text turn = new Text("Turn:");
		turn.setTranslateX(width-turn.getBoundsInParent().getWidth()-150);
		turn.setFont(Font.font(50));
		turn.setTranslateY(100);
		
		
		who.setText("Dark");
		who.setTranslateX(width - who.getBoundsInParent().getWidth()-100);
		who.setFont(Font.font(40));
		who.setTranslateY(150);
		
		this.getChildren().add(who);
		this.getChildren().add(turn);
		
		
		sqare.setOnMouseClicked(e->{
			
			
		});
		
		/*
		 * 0. inget
		 * 1.Bonde
		 * 2.Löpare
		 * 3.Ryttare
		 * 4.Torn
		 * 5.Kung
		 * 6.Dam
		 */
		for(int y = 0; y< 8; y++){
			ArrayList<Node> row = new ArrayList<Node>();
			for(int x = 0; x< 8; x++){
				
				piece pec; 
				if( y  < 4){
					if(pieces[y][x] == 0){
						Nopiece piece = new Nopiece(y, x);
						piece.setTranslateZ(-20);
						row.add(piece);
					}
					if(pieces[y][x] == 11){
						row.add(new Pawn(y,x));
					}
					if(pieces[y][x] == 12){
						row.add(new Bishop(y,x));
					}
					if(pieces[y][x] == 13){
						row.add(new Knight(y,x));
					}
					if(pieces[y][x] == 14){
						row.add(new Rook(y,x));
					}
					if(pieces[y][x] == 15){
						row.add(new King(y,x));
					}
					if(pieces[y][x] == 16){
						row.add(new Queen(y,x));
					}
				}else {
					if(pieces[y][x] == 0){
						Nopiece piece = new Nopiece(y, x);
						piece.setTranslateZ(-20);
						row.add(piece);
					}
					if(pieces[y][x] == 21){
						piece piece = new Pawn(y,x);
						piece.setTranslateZ(20);
						piece.setTeam(2);
						row.add(piece);
					}
					if(pieces[y][x] == 22){
						piece piece = new Bishop(y,x);
						piece.setTeam(2);
						row.add(piece);
					}
					if(pieces[y][x] == 23){
						piece piece = new Knight(y,x);
						piece.setTeam(2);
						row.add(piece);
					}
					if(pieces[y][x] == 24){
						piece piece = new Rook(y,x);
						piece.setTeam(2);
						row.add(piece);
					}
					if(pieces[y][x] == 25){
						piece piece = new King(y,x);
						piece.setTeam(2);
						row.add(piece);
					}
					if(pieces[y][x] == 26){
						piece piece = new Queen(y,x);
						piece.setTeam(2);
						row.add(piece);;
					}
				}
				
			}
			MapPiece.add(row);
		}
		for(int x = 0; x<MapPiece.size(); x++){
			this.getChildren().addAll(MapPiece.get(x));
		}
		
		/*
		for(int x = 0; x<MapPiece.size(); x++){
			for(int y = 0; y<MapPiece.get(x).size(); y++){
				System.out.print("|" +MapPiece.get(x).get(y).getClass().getSimpleName());
				
			}
			System.out.println();
		}
		*/
		
		
		
	}
	
	
	
	public void ArraySwap(int y1, int x1, int y2, int x2) {
		
		
		
		
		piece temp = (piece) MapPiece.get(y2).get(x2);
		MapPiece.get(y2).set(x2, MapPiece.get(y1).get(x1));
		MapPiece.get(y1).set(x1, temp);
		
	
		
	}
	
	
	public ArrayList<ArrayList<Node>> getMapPiece() {
		return MapPiece;
	}
	
	
	AnimationTimer timer = new AnimationTimer() {
		
		@Override
		public void handle(long now) {
			// TODO Auto-generated method stub
			for (int i = 0; i < Exec.getBoard().getMapPiece().size(); i++) {
				for (int j = 0; j < Exec.getBoard().getMapPiece().get(i).size(); j++) {
					System.out.print(Exec.getBoard().getMapPiece().get(i).get(j).getClass().getSimpleName()+"   ");
				}
				System.out.println();
			}
			
		}
	};
	public static void nextTurn() {
		// TODO Auto-generated method stub

		if(teamPlaying == 1){
			teamPlaying = 2;
			who.setText("dark");
		}else{
			teamPlaying = 1;
			who.setText("light");
		}
	}
	
	public piece getPiece(int y, int x) {
		// TODO Auto-generated method stub

		if(y > MapPiece.size() || y<0){
			return null;
		}
		if(x > MapPiece.get(y).size() || x<0){
			return null;
		}
		
		return (piece) MapPiece.get(y).get(x);
		
		
		
	}
	
	public static int getTeamPlaying() {
		return teamPlaying;
	}
	
	
}
