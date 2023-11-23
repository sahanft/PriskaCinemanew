package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManagerDashBoardController {
    public AnchorPane root;
    public AnchorPane root2;


    public void employee_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageemployee.fxml")));


    }

    public void seat_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "seat1.fxml")));


    }

    public void parking_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageparking.fxml")));

    }

    public void payment_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managepayment.fxml")));

    }

    public void producer_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageproducer.fxml")));

    }

    public void ticket_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageticket.fxml")));

    }


    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managerloginpage.fxml")));

    }


    public void dashboard_onaction(ActionEvent actionEvent) throws IOException {

        root2.getChildren().clear();
        root2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "dashboard1.fxml")));



    }
}
