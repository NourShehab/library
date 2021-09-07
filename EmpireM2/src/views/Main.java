package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
	
	static Stage window;
	public Button start;
	ChoiceBox <String> cityBox;
	TextField name;
	Controller c= new Controller();
	Scene scene;
	static String state;
	static String PreState="";
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window=primaryStage;
		window.setTitle("The Conqurer");
		
		start = new Button();
		start.setText("Start");
		start.setPrefSize(200, 80);
		start.setCursor(Cursor.HAND);
		start.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,40));
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
		start.setBackground(bg1);
		start.setOnAction(this);
		start.setFocusTraversable(false);
		Label nameLabel = new Label ("Enter Name:");
		nameLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,30));
		//nameLabel.setTextFill(Color.BROWN);
		//nameLabel.setBackground(new Background (new BackgroundFill(Color.,CornerRadii.EMPTY , Insets.EMPTY)));
		name = new TextField();
		name.setPromptText("name");
		name.setPrefSize(200,30);
		name.setBackground(new Background (new BackgroundFill(Color.BLANCHEDALMOND,CornerRadii.EMPTY , Insets.EMPTY)));
		
		Label cityLabel = new Label ("Choose City");
		cityLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,30));
		//cityLabel.setTextFill(Color.FLORALWHITE);
		
		cityBox = new ChoiceBox<>();
		cityBox.getItems().addAll("Cairo","Rome","Sparta");
		cityBox.setValue("Cairo");
		cityBox.setPrefSize(200,30);
		cityBox.setBackground(new Background (new BackgroundFill(Color.BLANCHEDALMOND,CornerRadii.EMPTY , Insets.EMPTY)));
		GridPane layout = new GridPane ();
		layout.setPadding(new Insets (10,10,10,10));
		layout.setVgap(8);
		layout.setHgap(10);
		FileInputStream inp = new FileInputStream("D:\\Projects\\EmpireM2\\images\\worldMap.jpg");
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
		
		layout.setBackground(bg);
		GridPane.setConstraints(nameLabel, 34, 35);
		GridPane.setConstraints(name, 34, 40);
		GridPane.setConstraints(cityLabel, 50, 35);
		GridPane.setConstraints(cityBox, 50, 40);
		GridPane.setConstraints(start, 40, 60);
		//StackPane layout = new StackPane();
		layout.getChildren().addAll(nameLabel,name,cityLabel,cityBox,start);
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		window.setX(bounds.getMinX());
		window.setY(bounds.getMinY());
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());
		
		scene = new Scene (layout,500,400);
	
		window.setScene(scene);

		window.show();
		
	}

	public static VBox getPanel() throws FileNotFoundException {
		
		Label turnsLabel =new Label ("Turns: "+ Controller.getTurns());
		//turnsLabel.setTextFill(Color.BLACK);
		turnsLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Label foodLabel = new Label ("Food: "+ Controller.getFood());
		//foodLabel.setTextFill(Color.BLACK);
		foodLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Label goldLabel = new Label ("Gold: "+ Controller.getGold());
		//goldLabel.setTextFill(Color.BLACK);
		goldLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Label nameLabel = new Label ("Name: "+ Controller.getName());
		//nameLabel.setTextFill(Color.BLACK);
		nameLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Button EndTurn= new Button ("End Turn");
		EndTurn.setPrefSize(200, 30);
		EndTurn.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		EndTurn.setCursor(Cursor.HAND);
		FileInputStream inp1 = new FileInputStream("D:\\Projects\\EmpireM2\\images\\Endturn.jpg");
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
		EndTurn.setBackground(bg1);
		EndTurn.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent arg0) {
				Boolean endturn = Controller.onEndTurn();
				try {
					if (endturn) {
						Views.display(window);
						}
					else {
						Boolean winner = Controller.FindWinner();
						if (winner) {
							Winner.displayWinner(window);
						}
						else 
							Winner.displayLoser(window);
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		VBox box= new VBox(5);
		box.getChildren().addAll(nameLabel,turnsLabel,foodLabel,goldLabel,EndTurn);
		FileInputStream inp = new FileInputStream("D:\\Projects\\EmpireM2\\images\\panelf.jpg");
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
		box.setBackground(bg);

		
		return box;

	}
public static VBox getPanel1() throws FileNotFoundException {
		
		Label turnsLabel =new Label ("Turns: "+ Controller.getTurns());
		//turnsLabel.setTextFill(Color.BLACK);
		turnsLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Label foodLabel = new Label ("Food: "+ Controller.getFood());
		//foodLabel.setTextFill(Color.BLACK);
		foodLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Label goldLabel = new Label ("Gold: "+ Controller.getGold());
		//goldLabel.setTextFill(Color.BLACK);
		goldLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Label nameLabel = new Label ("Name: "+ Controller.getName());
		//nameLabel.setTextFill(Color.BLACK);
		nameLabel.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Button EndTurn= new Button ("End Turn");
		EndTurn.setPrefSize(200, 30);
		EndTurn.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		EndTurn.setCursor(Cursor.HAND);
		FileInputStream inp1 = new FileInputStream("D:\\Projects\\EmpireM2\\images\\Endturn.jpg");
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
		EndTurn.setBackground(bg1);
		EndTurn.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent arg0) {
				Boolean endturn = Controller.onEndTurn();
				try {
					if (endturn) {
						if (state.equals("WorldMapView")) {
							WorldMapView.display(window);
						}
					else if (state.equals("MyCitiesView")) {
						MyCitiesView.display(window);
					}
					else if (state.equals("Cairo")) {
						Cairo.display(window);
					}
					}
					else {
						Boolean winner = Controller.FindWinner();
						if (winner) {
							Winner.displayWinner(window);
						}
						else 
							Winner.displayLoser(window);
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	
		Button Back = new Button ("Back");
		Back.setPrefSize(200, 30);
		Back.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		Back.setCursor(Cursor.HAND);
		Back.setBackground(bg1);
		Back.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					if (state.equals("WorldMapView") ||state.equals("MyCitiesView") ) {
						Views.display(window);
						state="Views";}
					else if (state.equals("Cairo")) {
						if (PreState=="WorldMapView") {
						WorldMapView.display(window);
						state="WorldMapView";}
						else if (PreState=="MyCitiesView") {
							MyCitiesView.display(window);
							state="MyCitiesView";
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		VBox box= new VBox(6);
		box.getChildren().addAll(nameLabel,turnsLabel,foodLabel,goldLabel,EndTurn,Back);
		FileInputStream inp = new FileInputStream("D:\\Projects\\EmpireM2\\images\\panelf.jpg");
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
		box.setBackground(bg);
	 
		return box;

	}
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==start) {
			try {
				c.startGame(name.getText(),cityBox.getValue());
				state ="Views";
				Views.display(window);
				//window.close();
				//window.setScene(scene);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	}
	
}