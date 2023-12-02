package lk.ijse.PriskaCinema.controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    public AnchorPane testingAnhcor ;

    public void initialize() throws IOException {
        loadslider();
    }

    private void loadslider() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/autoimageslider.fxml"));
        this.testingAnhcor.getChildren();
        this.testingAnhcor.getChildren().add(root);
    }











}
