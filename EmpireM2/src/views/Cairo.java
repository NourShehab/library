package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controller.Controller;
import exceptions.NotEnoughGoldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Cairo {

public static void display( Stage window) throws FileNotFoundException {
	GridPane layout = new GridPane ();
	layout.setPadding(new Insets (10,10,10,10));
	layout.setVgap(8);
	layout.setHgap(10);
	FileInputStream inp = new FileInputStream("D:\\Projects\\EmpireM2\\images\\CairoBackground.jpg");
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
	Button market = new Button("Market"+"\n"+ "Cost = 1500$");
	Text marketCost= new Text("Cost = 1500$");
	market.setPrefSize(200, 50);
	Button farm = new Button("Farm");
	farm.setPrefSize(200, 50);
	Button archeryRange = new Button("Archery Range");
	archeryRange.setPrefSize(200, 50);
	Button stable = new Button("Stable");
	stable.setPrefSize(200, 50);
	Button barracks = new Button("Archery Range");
	barracks.setPrefSize(200, 50);
	
	Button marketImage = new Button();
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
	marketImage.setBackground(bg1);
	marketImage.setPrefSize(200, 200);
	GridPane.setConstraints(marketImage, 2, 2);
	
	if (Controller.FarmOwned("Cairo")) {
		 farm.setDisable(true);
	 }
	if (Controller.MarketOwned("Cairo")) {
		layout.getChildren().add(marketImage);
		market.setDisable(true);
	 }
	if (Controller.ArcheryRangeOwned("Cairo")) {
		 archeryRange.setDisable(true);
	 }
	if (Controller.StableOwned("Cairo")) {
		 stable.setDisable(true);
	 }
	if (Controller.BarracksOwned("Cairo")) {
		 barracks.setDisable(true);
	 }


	market.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) {
			try {
				Controller.OnBuild("Market","Cairo");
			} catch (NotEnoughGoldException e) {
				AlertBox.display("error","Not enough gold");
				 
				e.printStackTrace();
			}
			layout.getChildren().add(marketImage);
			market.setDisable(true);
		}
		
	});
	
	VBox build = new VBox(5);
	HBox marketbutton= new HBox(2);
	marketbutton.getChildren().addAll(market,marketCost);
	VBox box = Main.getPanel1();
	build.getChildren().addAll(farm,marketbutton,archeryRange,stable,barracks,box);
	GridPane.setConstraints(build, 1, 1);
	layout.getChildren().add(build);
	
	Scene scene = new Scene(layout);
	window.setScene(scene);
}

}