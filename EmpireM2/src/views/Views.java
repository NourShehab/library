package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Views {

	public static void display( Stage window) throws FileNotFoundException {
		
		
		//window.setTitle(title);
	
		Button myCities= new Button ("My Cities");
		myCities.setPrefSize(200, 50);
		myCities.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		myCities.setCursor(Cursor.HAND);
		myCities.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					Main.state ="MyCitiesView";
					MyCitiesView.display(window);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		Button worldMap = new Button ("World Map");
		worldMap.setPrefSize(200, 50);
		worldMap.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		worldMap.setCursor(Cursor.HAND);
		worldMap.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					Main.state ="WorldMapView";
					WorldMapView.display(window);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Button conquer = new Button ("Conquer!!");
		conquer.setPrefSize(200, 50);
		conquer.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20));
		conquer.setCursor(Cursor.HAND);
		conquer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("conquer");
				
			}
			
		});
		
		GridPane layout = new GridPane ();
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
		
		myCities.setBackground(bg1);
		worldMap.setBackground(bg1);
		conquer.setBackground(bg1);
		
		VBox box = Main.getPanel();
		//box.setVisible(true);
		GridPane.setConstraints(myCities, 25, 30);
		GridPane.setConstraints(worldMap, 45, 30);
		GridPane.setConstraints(conquer, 65, 30);
		GridPane.setConstraints(box, 68, 1);
		
		layout.getChildren().addAll(myCities,worldMap,conquer,box);
		//Scene x = new Scene(layout,200,200);
	
		//StackPane layout = new StackPane();
		//layout.getChildren().addAll(BattleButton,LaySiegeButton);
		/*Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		window.setX(bounds.getMinX());
		window.setY(bounds.getMinY());
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());*/
		
		
		Scene scene = new Scene (layout);
		window.setScene(scene);
		//window.show();
		//window.showAndWait();
		
	}
	

	
}
