package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AttendansController {
    public AnchorPane attendansroot;

    public void back_onaction(ActionEvent actionEvent) throws IOException {

        attendansroot.getChildren().clear();
        attendansroot.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageemployee.fxml")));




    }
}
