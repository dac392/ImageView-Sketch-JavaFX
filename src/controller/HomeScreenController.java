package controller;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.Photo;

public class HomeScreenController {

    @FXML
    private TextField captionField;
    @FXML
    private TextField photoNameField;

    @FXML
    private Label imageName;
    
    @FXML
    private Button delete;

    @FXML
    private ListView<Photo> photoList;
    
    private ObservableList<Photo> data;

    private ArrayList<Photo> album;
    
    private String filepath;

    public void start(Stage mainStage) {
    	album = new ArrayList<>();
    	data = FXCollections.observableArrayList();
    	photoList.setItems(data);
    	photoList		
    	.getSelectionModel()
		.selectedIndexProperty()
		.addListener( (obs, oldVal, newVal) -> select(mainStage));
    	photoNameField.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.MOVE);
        });
    	
        photoList.setCellFactory(new Callback< ListView<Photo>, ListCell<Photo> >() {
            @Override 
            public ListCell<Photo> call(ListView<Photo> list) {
                return new PhotoCell();
            }
        }
    );
    	
    }
    private void select(Stage mainStage) {
		Photo selected = photoList.getSelectionModel().getSelectedItem();
		if(selected != null) {
	    	imageName.setText(selected.getName());
		}
	}
    
	@FXML
    void addPhoto(ActionEvent event) {
    	String name = photoNameField.getText().strip();
    	String caption = captionField.getText().strip();
    	Photo newItem = new Photo(name, caption, filepath);
    	
    	album.add(newItem);
    	data.clear();
    	for(Photo p : album) {
    		data.add(p);
    	}
    	photoList.setItems(data);
    	

    	
    	
        int indexOfNewImage = data.size()-1;
        photoList.getSelectionModel().select(indexOfNewImage);
        photoNameField.clear();
        captionField.clear();
    	
    }

    @FXML
    void deletePhoto(ActionEvent event) {
    	Photo selected = photoList.getSelectionModel().getSelectedItem();
    	album.remove(selected);
    	data.clear();
    	for(Photo photo : album) {
    		data.add(photo);
    	}
    	photoList.setItems(data);
    	
    }
    
    @FXML
    void getFilePath(DragEvent event) {
        Dragboard r = event.getDragboard();
        if(event.getDragboard().hasFiles()){
        	
            File draggedFile = r.getFiles().get(0);
            boolean isAccepted = draggedFile.getName().toLowerCase().endsWith(".png")
            		||draggedFile.getName().toLowerCase().endsWith(".bmp")
            		||draggedFile.getName().toLowerCase().endsWith(".gif")
            		||draggedFile.getName().toLowerCase().endsWith(".jpeg")
            		||draggedFile.getName().toLowerCase().endsWith(".jpg");
            
            if(isAccepted) {
            	filepath = draggedFile.toURI().toString();
            	System.out.println(filepath);
//            	photoNameField.setText(filepath);
//            	Image a = new Image();
            	
            	
            }
            
        }
    }

}
