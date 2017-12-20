package tanilsoo.filesystem.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tanilsoo.filesystem.ui.controllers.InterfaceController;

public class UserInterface extends Application {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage pStage) throws Exception {
		BorderPane root = (BorderPane)loadController("Main.fxml", new InterfaceController());
		
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		scene.getStylesheets().add(getClass().getResource("Theme.css").toExternalForm());
		
		pStage.setTitle("Failisüsteem");
		pStage.setScene(scene);
		pStage.show();
	}
	
	private Parent loadController(String location, Initializable controller) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(location));
		fxmlLoader.setController(controller);
		return fxmlLoader.load();
	}

}
