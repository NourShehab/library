package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Winner {

public static void displayWinner( Stage window) throws FileNotFoundException {
	
	
	Button Exit = new Button("exit");
	Exit.setPrefSize(200, 50);
	Exit.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
	GridPane layout = new GridPane ();
	layout.setPadding(new Insets (5,5,5,5));
	layout.setVgap(8);
	layout.setHgap(10);
	FileInputStream inp = new FileInputStream("D:\\Projects\\EmpireM2\\images\\background.gif");
	//image creation
	Image im = new Image(inp);
	// create a background image
	BackgroundImage bi = new BackgroundImage(im,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bg = new Background(bi);
	Label winner = new Label ( "Congratulations you won!!");
	winner.setPrefSize(600, 100);
	winner.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,40));
	
	layout.setBackground(bg);
	
	FileInputStream inp1 = new FileInputStream("D:\\Projects\\EmpireM2\\images\\preview1.jpg");
	//image creation
	Image im1 = new Image(inp1);
	// create a background image
	BackgroundImage bi1 = new BackgroundImage(im1,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bg1 = new Background(bi1);
	
	Exit.setBackground(bg1);
	Exit.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			window.close();
			
		}
		
	});
	//VBox box = new VBox();
	GridPane.setConstraints(Exit, 60, 70);
	GridPane.setConstraints(winner, 50, 40);
	
	layout.getChildren().addAll(Exit,winner);

	Scene scene = new Scene (layout);
	window.setScene(scene);
		//window.show();
		//window.showAndWait();
		
	}
public static void displayLoser( Stage window) throws FileNotFoundException {
	
	
	Button Exit = new Button("exit");
	Exit.setPrefSize(200, 50);
	Exit.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
	GridPane layout = new GridPane ();
	layout.setPadding(new Insets (5,5,5,5));
	layout.setVgap(8);
	layout.setHgap(10);
	FileInputStream inp = new FileInputStream("D:\\Projects\\EmpireM2\\images\\background.gif");
	//image creation
	Image im = new Image(inp);
	// create a background image
	BackgroundImage bi = new BackgroundImage(im,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bg = new Background(bi);
	Label winner = new Label ("Hard Luck You Lost");
	winner.setPrefSize(600, 100);
	winner.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,40));
	
	layout.setBackground(bg);
	
	FileInputStream inp1 = new FileInputStream("D:\\Projects\\EmpireM2\\images\\preview1.jpg");
	//image creation
	Image im1 = new Image(inp1);
	// create a background image
	BackgroundImage bi1 = new BackgroundImage(im1,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bg1 = new Background(bi1);
	
	Exit.setBackground(bg1);
	Exit.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			window.close();
			
		}
		
	});
	//VBox box = new VBox();
	GridPane.setConstraints(Exit, 60, 70);
	GridPane.setConstraints(winner, 50, 40);
	
	layout.getChildren().addAll(Exit,winner);

	Scene scene = new Scene (layout);
	window.setScene(scene);
		//window.show();
		//window.showAndWait();
		
	}
}
