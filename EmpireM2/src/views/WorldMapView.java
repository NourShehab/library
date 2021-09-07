package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WorldMapView {
	
public static void display( Stage window) throws FileNotFoundException {
		//window.setTitle(title);
	Button SpartaButton = new Button();
	Button CairoButton = new Button();
	Button RomeButton = new Button();
	GridPane layout = new GridPane ();
	SpartaButton.setCursor(Cursor.HAND);
	CairoButton.setCursor(Cursor.HAND);
	RomeButton.setCursor(Cursor.HAND);
	layout.setPadding(new Insets (10,10,10,10));
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
	
	layout.setBackground(bg);
	FileInputStream inpSparta = new FileInputStream("D:\\Projects\\EmpireM2\\images\\Sparta1.jpg");
	//image creation
	Image imSparta = new Image(inpSparta);
	// create a background image
	BackgroundImage biSparta = new BackgroundImage(imSparta,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bgSparta= new Background(biSparta);
	SpartaButton.setPrefSize(300, 200);
	SpartaButton.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
	SpartaButton.setBackground(bgSparta);
	SpartaButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (Controller.CityOwned("Sparta")) {
					Main.state="Sparta";
					Main.PreState="WorldMapView";
					try {
						Sparta.display(window);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				else {
					AlertBox.display("Error", "You can't enter the city yet. Conquer it first.");
				}
			}
		});
	
	//image creation
	Image imCairo = new Image(new FileInputStream("D:\\Projects\\EmpireM2\\images\\cairo.jpg"));
	// create a background image
	BackgroundImage biCairo= new BackgroundImage(imCairo,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bgCairo= new Background(biCairo);
	CairoButton.setPrefSize(300, 200);
	CairoButton.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
	CairoButton.setBackground(bgCairo);
	CairoButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (Controller.CityOwned("Cairo")) {
					Main.state="Cairo";
					Main.PreState="WorldMapView";
					try {
						Cairo.display(window);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				else {
					AlertBox.display("Error", "You can't enter the city yet. Conquer it first.");
				}
			}
		});
	Image imRome = new Image(new FileInputStream("D:\\Projects\\EmpireM2\\images\\Rome.jpg"));
	// create a background image
	BackgroundImage biRome= new BackgroundImage(imRome,
	BackgroundRepeat.NO_REPEAT,
	BackgroundRepeat.NO_REPEAT,
	BackgroundPosition.DEFAULT,
	BackgroundSize.DEFAULT);
	// Background creation
	Background bgRome= new Background(biRome);
	RomeButton.setPrefSize(300, 200);
	RomeButton.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
	RomeButton.setBackground(bgRome);
	RomeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (Controller.CityOwned("Rome")) {
					Main.state="Rome";
					Main.PreState="WorldMapView";
					try {
						Rome.display(window);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				else {
					AlertBox.display("Error", "You can't enter the city yet. Conquer it first.");
				}
			}
		});
	VBox box = Main.getPanel1();
	VBox Cities = new VBox ();
	Cities.getChildren().addAll(SpartaButton,CairoButton,RomeButton);
	//GridPane.setConstraints(SpartaButton, 25, 40);
	//GridPane.setConstraints(CairoButton, 30, 40);
	GridPane.setConstraints(Cities, 1, 1);
	GridPane.setConstraints(box, 97, 1);
	layout.getChildren().addAll(box,Cities);

		Scene scene = new Scene (layout);
		window.setScene(scene);
		//window.show();
		//window.showAndWait();
		
	}
}
