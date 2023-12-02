package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EmployeeDashBoardController {

    public AnchorPane root4;



    public AnchorPane root3;


    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root3.getChildren().clear();
        root3.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "emploginpage.fxml")));


    }

    public void dashboard_onaction(ActionEvent actionEvent) throws IOException {

        root4.getChildren().clear();
        root4.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "dashboard2.fxml")));


    }

    public void seat_onaction(ActionEvent actionEvent) throws IOException {

        root4.getChildren().clear();
        root4.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "seat1.fxml")));


    }

    public void ticket_onaction(ActionEvent actionEvent) throws IOException {

        root4.getChildren().clear();
        root4.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageticket.fxml")));


    }

    public void parking_onaction(ActionEvent actionEvent) throws IOException {

        root4.getChildren().clear();
        root4.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageparking.fxml")));


    }


}
