package lk.ijse.PriskaCinema.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.PriskaCinema.Bo.Custom.ProducerBo;
import lk.ijse.PriskaCinema.Bo.Impl.ProducerBoImpl;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;
import lk.ijse.PriskaCinema.model.ManageEmployeeModel;
import lk.ijse.PriskaCinema.model.ManageProducerModel;
import lk.ijse.PriskaCinema.model.ManageTicketModel;
import lk.ijse.PriskaCinema.tm.EmployeeTm;
import lk.ijse.PriskaCinema.tm.ProducerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static lk.ijse.PriskaCinema.model.ManageProducerModel.loadAllproducer;

public class ManageProducerController {
    public TextField producerid_txt;
    public TextField name_txt;
    public TextField address_txt;
    public TextField mobilenumber_txt;
    public AnchorPane producerroot;
    public TableView producer_tm;
    public TableColumn name_tm;
    public TableColumn id_tm;
    public TableColumn address_tm;
    public TableColumn mobile_tm;


    ProducerBo producerBo = new ProducerBoImpl();

    public void initialize() {
        setCellValueFactory();
        clearField();
        loadAllProducer();
        tableListener();

    }

    public void next_onaction(ActionEvent actionEvent) throws IOException {

        producerroot.getChildren().clear();
        producerroot.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managemovies.fxml")));

    }




    public void add_onaction(ActionEvent actionEvent) throws SQLException {

        String id = producerid_txt.getText();
        String name = name_txt.getText();
        String address = address_txt.getText();
        String mobile = mobilenumber_txt.getText();

        var dto = new ManageProducerDto(id,name,address,mobile);

        try {
            boolean isSaved = producerBo.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Producer Save").show();
                loadAllProducer();
                clearField();
            }
            producer_tm.getItems().add(new ProducerTm(id,name,address,mobile));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        producer_tm.refresh();

    }



    private void setCellValueFactory() {
        id_tm.setCellValueFactory(new PropertyValueFactory<>("producerid"));
        name_tm.setCellValueFactory(new PropertyValueFactory<>("name"));
        address_tm.setCellValueFactory(new PropertyValueFactory<>("address"));
        mobile_tm.setCellValueFactory(new PropertyValueFactory<>("mobilenumber"));


    }
    private void setData(ProducerTm row) {
        producerid_txt.setText(row.getProducerid());
        name_txt.setText(row.getName());
        address_txt.setText(row.getAddress());
        mobilenumber_txt.setText(row.getMobilenumber());

    }

    public void tableListener(){
        producer_tm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData((ProducerTm) newValue);
        });
    }


    private void clearField() {
        producerid_txt.setText("");
        name_txt.setText("");
        address_txt.setText("");
        mobilenumber_txt.setText("");
    }



    public void update_onaction(ActionEvent actionEvent) {
        String id = producerid_txt.getText();
        String name = name_txt.getText();
        String address = address_txt.getText();
        String tele = mobilenumber_txt.getText();

        try {
            var dto = new ManageProducerDto(id,name,address,tele);
            boolean isUpdated = producerBo.update(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "ticket details updated").show();;
                clearField();
                loadAllProducer();
            } else {
                new Alert(Alert.AlertType.ERROR, "ticket details not updated").show();;
            }
            producer_tm.getItems().add(new ProducerTm(id,name,address,tele));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            clearField();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    public void delete_onaction(ActionEvent actionEvent) {
        String id = producerid_txt.getText();

//        var model = new CustomerModel();
        try {
            boolean isDeleted = ManageProducerModel.deleteProducer(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "producer deleted!").show();
                loadAllProducer();

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "producer not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void loadAllProducer() {

        ObservableList<ProducerTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageProducerDto> dtoList = (ArrayList<ManageProducerDto>) loadAllproducer();

            for (ManageProducerDto dto : dtoList) {
                obList.add(
                        new ProducerTm(
                                dto.getProducerid_txt(),
                                dto.getName_txt(),
                                dto.getAddress_txt(),
                                dto.getMobilenumber_txt()


                        )
                );
            }

            producer_tm.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
