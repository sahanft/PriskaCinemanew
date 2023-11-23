/*
package lk.ijse.PriskaCinema.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class EmployeeDashBoardController {


    public AnchorPane root3;
    public AnchorPane root4;
   */
/* public AnchorPane root5;
    public JFXButton seat;
    public JFXButton tiket;
    public JFXButton parking;
*//*






    public void initialize() throws IOException {
        seat_onaction(null);
    }
    void setForm(String form) throws IOException {
        String[] formArray = {"/view/seat1.fxml", "/view/manageticket.fxml" ,"/view/manageparking.fxml"};

        JFXButton[] btnArray = {seat, tiket, parking};
        AnchorPane load = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(form)));
        root5.getChildren().clear();
        root5.getChildren().add(load);
        for (int i = 0; i < formArray.length; i++) {
            btnArray[i].setStyle("-fx-background-color:  #380047; -fx-font-size: 15; -fx-text-fill: #f6e6d0");

            if (form.equals(formArray[i])){
                btnArray[i].setStyle("-fx-background-color: #eed5ff; -fx-text-fill: #380047");
            }
        }
    }
    */
/*public void monthlyIncomeOnAction(ActionEvent event) throws IOException {
        setForm("/view/monthlyincome.fxml");
    }

    public void itemOnAction(ActionEvent event) throws IOException {
        setForm("/view/AddItem.fxml");
    }

    public void EmployeeOnAction(ActionEvent event) throws IOException {
        setForm("/view/addEmployee.fxml");
    }

    public void SupplierOnAction(ActionEvent event) throws IOException {
        setForm("/view/AddSupplier.fxml");
    }

    public void DeliverOnAction(ActionEvent event) throws IOException {
        setForm("/view/Diliver.fxml");
    }

    public void CustomerOnAction(ActionEvent event) throws IOException {
        setForm("/view/AddCustomer.fxml");
    }*//*










    public void seat_onaction(ActionEvent actionEvent) throws IOException {
       setForm("/view/seat1.fxml");


    }

    public void ticket_onaction(ActionEvent actionEvent) throws IOException {
       setForm("/view/manageticket.fxml");



    }

    public void parking_onaction(ActionEvent actionEvent) throws IOException {
        setForm("/view/manageparking.fxml");



    }


    public void dashboard_onaction(ActionEvent actionEvent) throws IOException {

        root4.getChildren().clear();
        root4.getChildren().add(FXMLLoader.load(getClass().getResource("/view/dashboard2.fxml")));




    }

    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root3.getChildren().clear();
        root3.getChildren().add(FXMLLoader.load(getClass().getResource("/view/emploginpage.fxml")));




    }
}
*/
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
