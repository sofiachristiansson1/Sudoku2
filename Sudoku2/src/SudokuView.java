import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		
		OneNumberTextField[][] textfields = new OneNumberTextField[9][9];
		
		
		for(int i=0;i<9;i++){
			for(int p=0;p<9;p++){
			textfields[i][p]= new OneNumberTextField();
			textfields[i][p].setPrefHeight(height/10);
			textfields[i][p].setPrefWidth(lenght/10);
			//textfields[i][p].setText("0");
			
			if((i==0 || i==1 || i==2 || i==6 || i==7 || i==8) && (p==0 || p==1 || p==2 || p==6 || p==7 || p==8)){
			textfields[i][p].setStyle("-fx-control-inner-background: blue");
			}
			if((i==3 ||i==4 ||i==5) && (p==3 || p==4 || p==5 )){
				textfields[i][p].setStyle("-fx-control-inner-background: blue");
			}
			
		}}
		
		for(int n=0;n<9;n++){
			for(int m=0;m<9;m++){
			background.getChildren().add(textfields[n][m]);
		}
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
		
		Sudoku sudoku = new Sudoku();
		
		solve.setOnAction(event -> { //då solve trycks gås alla textfield igenom och värdet i textfield läggs till i board
			for(int n=0;n<9;n++){
				for(int m=0;m<9;m++){
					if(textfields[n][m].getText().isEmpty()){
						sudoku.insertNumber(0, n, m);
					}else{
						int a = Integer.valueOf(textfields[n][m].getText());
						sudoku.insertNumber(a, n, m);
					}
				}
			}
			if(sudoku.solve(0, 0)){ //om lösbart så skrivs värdet i rutan från bord in i motsvarande textfield
				for(int n=0;n<9;n++){
					for(int m=0;m<9;m++){
						textfields[n][m].setText(String.valueOf(sudoku.getNumber(n, m)));
						
					}
				}
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Det här sudokut är ej lösbart");
				alert.showAndWait();
			}
			
		});
		
		
		clear.setOnAction(event -> {
			sudoku.clear();
			for(int n=0;n<9;n++){
				for(int m=0;m<9;m++){
					textfields[n][m].setText("");
					
				}
			}
		});

	}
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}
