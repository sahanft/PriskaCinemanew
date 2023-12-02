package lk.ijse.PriskaCinema.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RightHandController {

    public AnchorPane testingAnhcor3 ;

    public void initialize() throws IOException {
        loadslider();
    }

    private void loadslider() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/autoimageslider.fxml"));
        this.testingAnhcor3.getChildren();
        this.testingAnhcor3.getChildren().add(root);
    }





}
