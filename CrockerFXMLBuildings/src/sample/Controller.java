package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.Building.buildings;


public class Controller implements Initializable {

    public Button button;

    public void handleClick() {
        //System.out.println("Ouch");
        //button.setText("Okay");
        //imageView.getImage();
    }

    // Declare variables for linking to FXML
    @FXML
    private ListView listView;
    @FXML
    private StackPane imagePane;
    @FXML
    private Label buildingName;
    @FXML
    private Label coordinates;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("loading user data...\n");

        try {
            //Load buildings from text file into array
            ArrayList<Building> buildings = Building.load();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

        //Testing output and adding names to listView
        for (Building b : buildings) {
            System.out.println(b.toString());
            listView.getItems().add(b.getName());
            //imageView.getImage();
        }

        //System.out.println(buildings.toString());
        System.out.println("\nuser data loaded.");

        //Add a listener and set the indexer
        listView.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                    int index = listView.getSelectionModel().getSelectedIndex();
                    Building b = buildings.get(index);

                    //Display Image, Name, and Coordinates
                    javafx.scene.image.ImageView image = new ImageView(new Image(b.getImageName()));
                    imagePane.getChildren().add(image);
                    buildingName.setText(b.getName());
                    coordinates.setText(b.getCoordinate().toString());
                }
        );

    }

}



