package lk.ijse.PriskaCinema.controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    public AnchorPane anroot;

    public void manager_onaction(ActionEvent actionEvent) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/managerloginpage.fxml"));
        anroot.getChildren().clear();
        anroot.getChildren().add(load);
    }

    public void employee_onaction(ActionEvent actionEvent) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/emploginpage.fxml"));
        anroot.getChildren().clear();
        anroot.getChildren().add(load);

    }
}
