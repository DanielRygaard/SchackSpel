package Map;
import Blocks.square;
import Pieces.piece;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Exec extends Application {

	
	
	
	Scene scene;
	public static Board board;
	
	public static double width = square.SIZE*10;
	public static double height = square.SIZE*8;
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
	
		board = new Board();
		
		
		System.out.println(board.getPiece(0, 2).getClass().getSimpleName());
		
		
		
	    scene = new Scene(board, width, height);
		
	    scene.setOnKeyPressed(e->{
			System.out.println("hej");
			if(e.getCode().equals(KeyCode.SPACE)){
				
				System.out.println("kill");
			}
		});
	    
	    stage.setScene(scene);
	    stage.show();
	    
		
		
	}
	public static Board getBoard() {
		return board;
	}
	
}
