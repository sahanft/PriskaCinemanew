package lk.ijse.PriskaCinema.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.PriskaCinema.Bo.Custom.ParkingBo;
import lk.ijse.PriskaCinema.Bo.Impl.ParkingBoImpl;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;
import lk.ijse.PriskaCinema.model.ManageParkingModel;
import lk.ijse.PriskaCinema.tm.ParkingTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class ManageParkingController implements Initializable {


    public Label lblParkingCount;
    @FXML
    private TableView <ParkingTm> parkingmain_txt;

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

    private ParkingTm newValue;

    private ParkingTm tm = new ParkingTm();

    ParkingBo parkingBo = new ParkingBoImpl();



    public void initialize() throws SQLException {
        setCellValueFactory();
        loadAllParking();
        clearField();
        tableListener();
        totalParking();
    }

    public void addparking_onaction(ActionEvent actionEvent) {
       String spacenum = spacemen_txt.getText();
       String spacetype = type_txt.getText();
       Double parkingfee = Double.valueOf(parking_txt.getText());
       LocalDate date = date_txt.getValue();


        var dto = new ManageParkingDto(spacenum,spacetype,parkingfee,date);

        try {
            boolean isSaved = parkingBo.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "vehicle Save").show();
                loadAllParking();
                totalParking();
                clearField();
            }
            parkingmain_txt.getItems().add(new ParkingTm(spacenum,spacetype,parkingfee,date));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        parkingmain_txt.refresh();

    }
    private void clearField(){
        spacemen_txt.clear();
        type_txt.clear();
        parking_txt.clear();
    }



    private void loadAllParking() {
        parkingmain_txt.getItems().clear();


        //ObservableList<ParkingTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageParkingDto> dtoList = (ArrayList<ManageParkingDto>) parkingBo.loadAll();

            for (ManageParkingDto dto : dtoList) {
                parkingmain_txt.getItems().addAll(
                //setDeleteBtnOnAction(btn,dto.getSpacemen_txt());
                        new ParkingTm(
                                dto.getSpacemen_txt(),
                                dto.getType_txt(),
                                dto.getParkingfee_txt(),
                                dto.getDate_txt()
                               // btn

                        ));
            }

            //parkingmain_txt.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private void setCellValueFactory() {
        parkingspace_txt.setCellValueFactory(new PropertyValueFactory<>("spaceNum"));
        parkingtype_txt.setCellValueFactory(new PropertyValueFactory<>("type"));
        parkingfee_txt.setCellValueFactory(new PropertyValueFactory<>("parkingFee"));
        parkingdate_txt.setCellValueFactory(new PropertyValueFactory<>("date"));


    }
    private void setData(ParkingTm row) {
       /* parkingspace_txt.setText(row.getSpaceNum());
        parkingtype_txt.setText(row.getType());
        parking_txt.setText(String.valueOf(row.getParkingFee()));
        parkingdate_txt.setText(String.valueOf(row.getDate()));*/
    }
    public void tableListener(){
//        parkingmain_txt.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            setData(newValue);
//        });
    }


    private void showErrorNotification(String invalidEmployeeName, String s) {
    }


    public void back_onaction(ActionEvent actionEvent) {
    }







    public void delete_onaction(ActionEvent actionEvent) {

        String id = spacemen_txt.getText();

        try{
            boolean isDelete = parkingBo.delete(id);
            if (isDelete){
                parkingmain_txt.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION,"vehicle delete").show();
                loadAllParking();
                totalParking();
                clearField();
            }else{
                new Alert(Alert.AlertType.ERROR,"vehicle not delete").show();
            }
            parkingmain_txt.getItems().remove(parkingmain_txt.getSelectionModel().getSelectedItem());
            loadAllParking();
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {
        String spaceNum = spacemen_txt.getText();
        String type = type_txt.getText();
        Double parkingfee = Double.parseDouble(parking_txt.getText());
        LocalDate date = date_txt.getValue();

        try {

            var dto = new ManageParkingDto(spaceNum, type, parkingfee,date);
            boolean isUpdated = parkingBo.update(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "parking details updated").show();;
                clearField();
                loadAllParking();
                totalParking();
            } else {
                new Alert(Alert.AlertType.ERROR, "parking details not updated").show();;
            }
            parkingmain_txt.getItems().add(new ParkingTm(spaceNum,type,parkingfee,date));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            clearField();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void print_onaction(ActionEvent actionEvent) throws JRException, SQLException {

        HashMap map = new HashMap<>();

        map.put("fee", tm.getParkingFee());
        map.put("space",tm.getSpaceNum());
        map.put("type", tm.getType());

        InputStream resourceAsStream =
                getClass().getResourceAsStream("../report/parkingticket.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport compileReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                        compileReport,
                        map,
                        new JREmptyDataSource()
                );
        JasperViewer.viewReport(jasperPrint, false);




    }

    public void mouseClicakAction(MouseEvent mouseEvent) {
        Integer index  = parkingmain_txt.getSelectionModel().getSelectedIndex() ;
        if(index <=-1){
            return;
        }
        tm.setDate(LocalDate.parse(parkingdate_txt.getCellData(index).toString()));
        tm.setParkingFee(Double.parseDouble(parkingfee_txt.getCellData(index).toString()));
        tm.setType(parkingtype_txt.getCellData(index).toString());
        tm.setSpaceNum(parkingspace_txt.getCellData(index).toString());

    }

    public void totalParking() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT SUM(parking_fee) FROM parking";

        double totalInCome = 0;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                totalInCome = resultSet.getDouble("SUM(parking_fee)");

            }
            lblParkingCount.setText("Rs. " + totalInCome);
            loadAllParking();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            totalParking();
            setCellValueFactory();
            loadAllParking();
            clearField();
            tableListener();
            totalParking();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
