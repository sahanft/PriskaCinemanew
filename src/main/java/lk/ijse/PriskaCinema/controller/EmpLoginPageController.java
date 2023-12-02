package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.PriskaCinema.db.DbConnection;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpLoginPageController {
    public TextField loginUserName;
    public PasswordField loginPassword;
    @FXML
    private AnchorPane root;
    public void login2_onaction(ActionEvent actionEvent) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/employeedashboard.fxml"));
        root.getChildren().clear();
        root.getChildren().add(load);

    }

    public void register2_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "oopspage.fxml")));

    }

    public void back2_onaction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "login.fxml")));
    }

    public void EmpLoginOnAction(ActionEvent actionEvent) throws SQLException {

        String username = loginUserName.getText();
        String password = loginPassword.getText();
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE euser_name = ? AND euser_password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            if(username.isEmpty() || password.isEmpty()) {
                new Alert(Alert.AlertType.ERROR,"Empty").show();
                return;
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/employeedashboard.fxml"));
                Scene scene = new Scene(rootNode);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.setTitle("Dashboard");
            } else {
                new Alert(Alert.AlertType.ERROR, "oops! credentials are wrong!").show();
                //clearField();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            //clearField();
        }
    }

    public AnchorPane testingAnhcor4 ;

    public void initialize() throws IOException {
        loadslider();
    }

    private void loadslider() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/autoimageslider.fxml"));
        this.testingAnhcor4.getChildren();
        this.testingAnhcor4.getChildren().add(root);
    }

}
