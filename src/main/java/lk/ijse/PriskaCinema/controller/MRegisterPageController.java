package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.EmployeeRegisterDTO;
import lk.ijse.PriskaCinema.dto.LoginDto;
import lk.ijse.PriskaCinema.model.ERegisterPageModel;
import lk.ijse.PriskaCinema.model.LoginModel;
import lk.ijse.PriskaCinema.model.MRegisterPageModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MRegisterPageController {


    public TextField mregisterpage_fullname;
    public TextField mregisterpage_nic;
    public PasswordField mregisterpage_password;
    public PasswordField mregisterpage_confirmpassword;
    public PasswordField password_txt;
    public PasswordField confirmpw_txt;
    public TextField nic_txt;
    public TextField fullname_txt;
    public AnchorPane root;

    public void mregisterpage_register_onaction(ActionEvent actionEvent) throws IOException {


    }



    public void mregisterlogin_onaction(ActionEvent actionEvent) {

    }

    public void mregisterpage_back_onaction(ActionEvent actionEvent) {

    }

    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managerloginpage.fxml")));


    }

    public void next_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "eregisterpage.fxml")));





    }

    public void login_onaction(ActionEvent actionEvent) throws IOException, SQLException {


    }

    public void register_onaction(ActionEvent actionEvent) throws IOException {
        String name = fullname_txt.getText();
        String password = password_txt.getText();

        var dto = new LoginDto(name,password);

        try {
            boolean isRegister = MRegisterPageModel.registerAdmin(dto);
            if (isRegister) {
                new Alert(Alert.AlertType.CONFIRMATION, "Register Successful").show();
                //clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managerloginpage.fxml")));

    }
}
