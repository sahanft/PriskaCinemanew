package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.security.cert.PolicyNode;



public class OopsPageController {
    @FXML
    private AnchorPane root;

    public void back_onaction(ActionEvent actionEvent) throws IOException {;
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "emploginpage.fxml")));
    }
}
