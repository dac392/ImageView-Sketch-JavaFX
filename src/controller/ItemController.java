package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.Photo;

public class ItemController {
	private Photo photo;
    @FXML
    private ImageView img;

    @FXML
    private Label title;

	public void setData(Photo newItem) {
		this.photo = newItem;
		title.setText(photo.getCaption());
		Image image = new Image(newItem.getURL());
		img.setImage(image);
	}

}
