package main;

import controller.HomeScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FxLists extends Application{
	public static void main(String[] args) {
		
		launch(args);
	}
	/**
	 * void method that loads the Login FXML. 
	 * @param for the main stage window.
	 * @author Abid Azad
	 */	
	public void start(Stage primaryStage){
		try {		
			FXMLLoader loader = new FXMLLoader();   
			loader.setLocation(getClass().getResource("/views/HomeView.fxml"));
			
			// load the fxml
			AnchorPane root = (AnchorPane)loader.load();

			// get the controller (Do NOT create a new Controller()!!)
			// instead, get it through the loader
			
			HomeScreenController listController = loader.getController();
			listController.start(primaryStage);
			
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
