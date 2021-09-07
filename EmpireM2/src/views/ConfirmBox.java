package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	static boolean Answer;

	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		window.setMinHeight(250);
		
		Label label = new Label();
		label.setText(message);
		
		/*Button closeButton = new Button ("Close the window");
		closeButton.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				window.close();
			}
		});*/
		Button BattleButton = new Button("Go to Battle");
		Button LaySiegeButton = new Button("LaySiege");
		
		BattleButton.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Answer = true;
				window.close();
			}
			
		});
		LaySiegeButton.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Answer = false;
				window.close();
			}
			
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,BattleButton,LaySiegeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene (layout);
		window.setScene(scene);
		window.showAndWait();
		return Answer;
	}

	
}
