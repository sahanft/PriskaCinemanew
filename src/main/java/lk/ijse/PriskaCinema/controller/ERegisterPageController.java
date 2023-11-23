package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.PriskaCinema.dto.EmployeeRegisterDTO;
import lk.ijse.PriskaCinema.model.ERegisterPageModel;

import java.io.IOException;
import java.sql.SQLException;

public class ERegisterPageController {
    public TextField eregisterpage_fullname;
    public TextField eregisterpage_nic;
    public PasswordField eregisterpage_password;
    public PasswordField eregisterpage_confirmpassword;
    public TextField fullname_txt;
    public TextField employeeid_txt;
    public PasswordField password_txt;
    public PasswordField confirmpw_onaction;
    public AnchorPane root;



    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managerloginpage.fxml")));


    }

    public void register_onaction(ActionEvent actionEvent) throws IOException {

            String name = fullname_txt.getText();
            String password = password_txt.getText();

            var dto = new EmployeeRegisterDTO(name,password);

            try {
                boolean isRegister = ERegisterPageModel.registerAdmin(dto);
                if (isRegister) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Register Successful").show();
                    clearField();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "emploginpage.fxml")));


    }

    private void clearField() {
    }
}
