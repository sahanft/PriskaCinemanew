package lk.ijse.PriskaCinema.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;
import lk.ijse.PriskaCinema.model.ManageEmployeeModel;
import lk.ijse.PriskaCinema.model.ManageParkingModel;
import lk.ijse.PriskaCinema.tm.ParkingTm;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageParkingController {


  //  public TextField parkingfee_txt;
    @FXML
    private TableView <ParkingTm>parkingmain_txt;

    @FXML
    private TableColumn<?,?> parkingspace_txt;
    @FXML
    private TableColumn<?,?> parkingtype_txt;
    @FXML
    private TableColumn<?,?> parkingfee_txt;
    @FXML
    private TableColumn<?,?> parkingdate_txt;
    @FXML
    private TableColumn<?,?> parkingdelete_txt;
    public TextField spacemen_txt;
    public TextField type_txt;
    public DatePicker date_txt;
    public TextField parking_txt;
    private ManageParkingModel manageParkingModel = new ManageParkingModel();

    public void initialize() {
        setCellValueFactory();
        loadAllParking();
    }

    public void addparking_onaction(ActionEvent actionEvent) {
       String spacenum = spacemen_txt.getText();
       String spacetype = type_txt.getText();
       String parkingfee = parking_txt.getText();
       LocalDate date = date_txt.getValue();


        var dto = new ManageParkingDto(spacenum,spacetype,parkingfee,date);

        try {
            boolean isSaved = ManageParkingModel.saveParking(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "vehicle Save").show();
                loadAllParking();
                clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
        parkingmain_txt.refresh();

    }
    private void clearField(){
        spacemen_txt.clear();
        type_txt.clear();
        parking_txt.clear();
    }



    private void loadAllParking() {

        ObservableList<ParkingTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageParkingDto> dtoList = (ArrayList<ManageParkingDto>) manageParkingModel.loadAllparking();

            for (ManageParkingDto dto : dtoList) {
                Button btn = new Button("remove");
                //setDeleteBtnOnAction(btn,dto.getSpacemen_txt());
                obList.add(
                        new ParkingTm(
                                dto.getSpacemen_txt(),
                                dto.getType_txt(),
                                dto.getParkingfee_txt(),
                                dto.getDate_txt()
                               // btn

                        ));
            }

            parkingmain_txt.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*private void setDeleteBtnOnAction(Button btn, String spacemenTxt) {
        btn.setOnAction(event -> {
            try {
                boolean isDeleted = manageParkingModel.deleteParking(spacemenTxt);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "vehicle Deleted").show();
                    loadAllParking();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        });
    }*/

    private void setCellValueFactory() {
        parkingspace_txt.setCellValueFactory(new PropertyValueFactory<>("spaceNum"));
        parkingtype_txt.setCellValueFactory(new PropertyValueFactory<>("type"));
        parkingfee_txt.setCellValueFactory(new PropertyValueFactory<>("parkingFee"));
        parkingdate_txt.setCellValueFactory(new PropertyValueFactory<>("date"));
        parkingdelete_txt.setCellValueFactory(new PropertyValueFactory<>("delete"));

    }
    private void setData(ParkingTm row) {
        parkingspace_txt.setText(row.getSpaceNum());
        parkingtype_txt.setText(row.getType());
        parkingfee_txt.setText(row.getParkingFee());
        parkingdate_txt.setText(String.valueOf(row.getDate()));
    }
    public void tableListener(){
        parkingmain_txt.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    public void back_onaction(ActionEvent actionEvent) {
    }

    public void update_onaction(ActionEvent actionEvent) {

    }

    public void delete_onaction(ActionEvent actionEvent) {

    }
}
