package lk.ijse.PriskaCinema.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ImageSliderController {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private AnchorPane main_form;

    private int count = 0;



    public void initialize() {
        // Create a timeline for the image slider
        Duration duration = Duration.seconds(3);
        KeyFrame keyFrame = new KeyFrame(duration, event -> nextImage());
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void nextImage() {
        // Define your translate transitions here
        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(3), image1);
        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(3), image2);
        TranslateTransition transition3 = new TranslateTransition(Duration.seconds(3), image3);
        TranslateTransition transition4 = new TranslateTransition(Duration.seconds(3), image4);

        // Set initial positions for the images
        transition1.setToX(0);
        transition2.setToX(500);
        transition3.setToX(1000);
        transition4.setToX(1500);

        // Play the transitions based on the count
        switch (count) {
            case 0:
                transition1.setToX(0);
                transition2.setToX(500);
                transition3.setToX(1000);
                transition4.setToX(1500);
                break;
            case 1:
                transition1.setToX(-500);
                transition2.setToX(0);
                transition3.setToX(500);
                transition4.setToX(1000);
                break;
            case 2:
                transition1.setToX(-1000);
                transition2.setToX(-500);
                transition3.setToX(0);
                transition4.setToX(500);
                break;
            case 3:
                transition1.setToX(-1500);
                transition2.setToX(-1000);
                transition3.setToX(-500);
                transition4.setToX(0);
                break;
        }

        transition1.play();
        transition2.play();
        transition3.play();
        transition4.play();

        // Update the count
        count = (count + 1) % 4;
    }


}
