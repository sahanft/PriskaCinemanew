package lk.ijse.PriskaCinema.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.PriskaCinema.Bo.BoFactory;
import lk.ijse.PriskaCinema.Bo.Custom.EmployeeBo;
import lk.ijse.PriskaCinema.Bo.Custom.SeatBo;
import lk.ijse.PriskaCinema.Bo.Impl.SeatBoImpl;
import lk.ijse.PriskaCinema.dto.Seat1Dto;
import lk.ijse.PriskaCinema.tm.SeateTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class Seat1Controller {
    public TextField seatnumber_txt;
    public TextField rownumber_txt;
    public TextField screen_txt;
    public TableView <SeateTm> seatTM;
    public TableColumn <?,?> Screen_tm;
    public TableColumn <?,?> rownumber_tm_;
    public TableColumn <?,?> seatnumber_tm;

    private ObservableList<SeateTm> obList = FXCollections.observableArrayList();

    SeatBo seatBo = (SeatBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.SEAT);

    public void initialize() {
        loadAllSeat();
        clearField();
        setCellValueFactory();
        tableListener();
    }
    public void add_onaction(ActionEvent actionEvent) throws SQLException {

        String seat = seatnumber_txt.getText();
        String screen = screen_txt.getText();
        String row = rownumber_txt.getText();


        var dto = new Seat1Dto(seat,screen,row);

        try {
            boolean isSaved = seatBo.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Seat Save").show();
                loadAllSeat();
                clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        seatTM.refresh();
    }

    private void clearField() {
        seatnumber_txt.setText("");
        screen_txt.setText("");
        rownumber_txt.setText("");

    }

    private void setCellValueFactory() {
        Screen_tm.setCellValueFactory(new PropertyValueFactory<>("screen"));
        rownumber_tm_.setCellValueFactory(new PropertyValueFactory<>("row"));
        seatnumber_tm.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));

    }

    private void setData(SeateTm row) {
        screen_txt.setText(row.getScreen());
        rownumber_txt.setText(row.getRow());
        seatnumber_txt.setText(String.valueOf(row.getSeatNumber()));

    }

    private void tableListener() {
        seatTM.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData( newValue);

        });
    }

    public void update_onaction(ActionEvent actionEvent) {
        String sNum = seatnumber_txt.getText();
        String screen = screen_txt.getText();
        String rowNum = rownumber_txt.getText();

        try {
            var dto = new Seat1Dto(sNum,screen,rowNum);
            boolean isUpdated = seatBo.update(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "ticket details updated").show();
                loadAllSeat();
                clearField();
            } else {
                new Alert(Alert.AlertType.ERROR, "ticket details not updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            clearField();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_onaction(ActionEvent actionEvent) {
        String id = seatnumber_txt.getText();
        Seat1Dto dto = new Seat1Dto(id);

        try {
            boolean isDelete = seatBo.delete(dto);
            if(isDelete) {
                seatTM.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION, "seat deleted!").show();
                loadAllSeat();
                clearField();

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "seat not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void loadAllSeat(){
        seatTM.getItems().clear();

        try{
            ArrayList<Seat1Dto> dtoList = (ArrayList<Seat1Dto>) seatBo.loadAll();

                    for (Seat1Dto dto :  dtoList){
                      //  obList.add(
                        seatTM.getItems().addAll(


                                new SeateTm(
                                        dto.getScreen_txt(),
                                        dto.getRownumber_txt(),
                                        dto.getSeatnumber_txt()

                                )
                        );
                    }
                //    seatTM.setItems(obList);
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
