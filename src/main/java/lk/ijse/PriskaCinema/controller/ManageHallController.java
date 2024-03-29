package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.PriskaCinema.Bo.BoFactory;
import lk.ijse.PriskaCinema.Bo.Custom.EmployeeBo;
import lk.ijse.PriskaCinema.Bo.Custom.HallBo;
import lk.ijse.PriskaCinema.Bo.Impl.HallBoImpl;
import lk.ijse.PriskaCinema.dto.ManageHallDto;
import lk.ijse.PriskaCinema.tm.HallTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageHallController {
    public AnchorPane hallroot;
    public TableView hall_tm;
    public TableColumn number_tm;
    public TableColumn category_tm;
    public TableColumn seat_tm;
    public TextField seat_txt;
    public TextField category_txt;
    public TextField number_txt;
    public TextField count_txt;
    public TableColumn count_tm;


    HallBo hallBo = (HallBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.HALL);

    public void initialize() throws IOException {
        setCellValueFactory();
        clearField();
        loadAllhall();
        loadslider();
        tableListener();

    }

    private void clearField() {
        number_txt.setText("");
        category_txt.setText("");
        count_txt.setText("");

    }

    @FXML
    void add_onaction(ActionEvent event) {
        String number = number_txt.getText();
        String category = category_txt.getText();
        String count = count_txt.getText();



        var dto = new ManageHallDto(number,category,count);

        try {
            boolean isSaved = hallBo.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "hall Save").show();
                loadAllhall();
                clearField();
            }
            hall_tm.getItems().add(new HallTm(number,category,count));
            loadAllhall();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        hall_tm.refresh();

    }

    private void loadAllhall() {
        hall_tm.getItems().clear();

       // ObservableList<HallTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageHallDto> dtoList = (ArrayList<ManageHallDto>) hallBo.loadAll();

            for (ManageHallDto dto : dtoList) {
                hall_tm.getItems().addAll(
                        new HallTm(
                                dto.getNumber_txt(),
                                dto.getCategory_txt(),
                                dto.getCount_txt()

                        ));
            }

           // hall_tm.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        number_tm.setCellValueFactory(new PropertyValueFactory<>("number"));
        category_tm.setCellValueFactory(new PropertyValueFactory<>("category"));
        count_tm.setCellValueFactory(new PropertyValueFactory<>("count"));



    }
    private void setData(HallTm row) {
        number_txt.setText(row.getNumber());
        category_txt.setText(row.getCategory());
        count_txt.setText(row.getCount());




    }
    public void tableListener(){
        hall_tm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData((HallTm) newValue);
        });
    }


    @FXML
    void delete_onaction(ActionEvent actionEvent) {
        String id = number_txt.getText();

        ManageHallDto dto = new ManageHallDto(id);
        try {
            boolean isDelete = hallBo.delete(dto);
            if(isDelete) {
                hall_tm.getSelectionModel().clearSelection();
                new Alert(Alert.AlertType.CONFIRMATION, "Hall deleted!").show();
                loadAllhall();
                clearField();

            } else {
                new Alert(Alert.AlertType.ERROR, "Hall not deleted!").show();
            }
            hall_tm.getItems().remove(hall_tm.getSelectionModel().getSelectedItem());
            loadAllhall();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void back_onaction(ActionEvent actionEvent) throws IOException {

        hallroot.getChildren().clear();
        hallroot.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managemovies.fxml")));



    }

    public AnchorPane testingAnhcor9 ;


    private void loadslider() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/autoimageslider.fxml"));
        this.testingAnhcor9.getChildren();
        this.testingAnhcor9.getChildren().add(root);
    }




}
