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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManLoginPageController {
    public TextField username_txt;
    public PasswordField password_txt;
    public AnchorPane loginAnchor;
    public AnchorPane root;


    public void login_onaction(ActionEvent actionEvent) throws IOException, SQLException {
        String username = username_txt.getText();
        String password = password_txt.getText();
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM admin WHERE auser_name = ? AND auser_password = ?";
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
                Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/managerdashboard.fxml"));
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

    public void login_forgotpassword(ActionEvent actionEvent) {

    }

    public void login_register(ActionEvent actionEvent) {

    }

    public void register_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "mregisterpage.fxml")));


    }

    public void back_onaction(ActionEvent actionEvent) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "login.fxml")));


    }
}
