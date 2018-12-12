import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class SudokuView extends Application {
	

	
	public void start(Stage stage) throws Exception {
		BorderPane root= new BorderPane();
		int lenght=500;
		int height=500;
		Scene scene = new Scene(root, lenght, height);
		stage.setTitle("Sudoku");
		stage.setScene(scene);
		stage.show();
		TilePane background = new TilePane();
		background.setPrefRows(9);
		background.setPrefColumns(9);
		background.setMaxWidth(lenght-50);
		
		OneNumberTextField[] textfields = new OneNumberTextField[81];
		
		for(int i=0;i<81;i++){
			textfields[i]= new OneNumberTextField();
			textfields[i].setPrefHeight(height/10);
			textfields[i].setPrefWidth(lenght/10);
		}
		
		for(int n=0;n<81;n++){
			background.getChildren().add(textfields[n]);
		}
		
		
		
		
		
		HBox hbox= new HBox();
		hbox.setSpacing(10);
		Button solve = new Button("Solve");
		Button clear = new Button("Clear");
		HBox.setHgrow(solve, Priority.ALWAYS);
		HBox.setHgrow(clear, Priority.ALWAYS);
		solve.setPrefWidth(lenght/2);
		clear.setPrefWidth(lenght/2);
		
		hbox.getChildren().add(solve);
		hbox.getChildren().add(clear);
		
		
		
		root.setCenter(background);
		root.setBottom(hbox);

	}
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}
