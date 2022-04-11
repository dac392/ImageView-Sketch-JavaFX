package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import util.Photo;

public class PhotoCell extends ListCell<Photo>{
	@Override public void updateItem(Photo item, boolean empty) {
		try {
			super.updateItem(item, empty);
			if(item != null && !empty) {
				FXMLLoader fxmlLoader = new FXMLLoader(); 
		    	fxmlLoader.setLocation(getClass().getResource("/views/ItemView.fxml"));
		    	AnchorPane root;
		    	root = fxmlLoader.load();
		    	ItemController itemController = fxmlLoader.getController();
		    	itemController.setData(item);
		    	setGraphic(root);
			}else {
				setGraphic(null);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		
    	
	}
}
