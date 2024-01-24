package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.PriskaCinema.Bo.BoFactory;
import lk.ijse.PriskaCinema.Bo.Custom.EregisterBo;
import lk.ijse.PriskaCinema.dto.EmployeeRegisterDTO;


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

    EregisterBo eregisterBo = (EregisterBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.EREGISTER);

    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "mregisterpage.fxml")));


    }

    public void register_onaction(ActionEvent actionEvent) throws IOException {

            String name = fullname_txt.getText();
            String password = password_txt.getText();

            var dto = new EmployeeRegisterDTO(name,password);

            try {
                boolean isRegister = eregisterBo.saveER(dto);
                if (isRegister) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Register Successful").show();
                    clearField();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "emploginpage.fxml")));


    }

    private void clearField() {
    }

    public AnchorPane testingAnhcor7 ;

    public void initialize() throws IOException {
        loadslider();
    }

    private void loadslider() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/autoimageslider.fxml"));
        this.testingAnhcor7.getChildren();
        this.testingAnhcor7.getChildren().add(root);
    }

}
