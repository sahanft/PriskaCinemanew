package lk.ijse.PriskaCinema.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.PriskaCinema.dto.AttendansDto;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;
import lk.ijse.PriskaCinema.model.AttendansModel;
import lk.ijse.PriskaCinema.model.ManageEmployeeModel;
import lk.ijse.PriskaCinema.tm.AttendensTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AttendansController {
    public AnchorPane attendansroot;
    public TableView<AttendensTm> attendans_tm;
    public TableColumn<?,?> id_tm;
    public TableColumn<?,?> name_tm;
    public TableColumn<?,?> delete_tm;

    public DatePicker date;
    public JFXComboBox<String> id_cobx;
    public Label lblName;

    private ObservableList<AttendensTm> obList = FXCollections.observableArrayList();

    public void initialize() {
        date.setPromptText(String.valueOf(LocalDate.now()));
        loadAllEmployee();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        id_tm.setCellValueFactory(new PropertyValueFactory<>("id_tm"));
        name_tm.setCellValueFactory(new PropertyValueFactory<>("name_tm"));
        delete_tm.setCellValueFactory(new PropertyValueFactory<>("delete_btn"));
    }
    public void back_onaction(ActionEvent actionEvent) throws IOException {

        attendansroot.getChildren().clear();
        attendansroot.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageemployee.fxml")));
    }

    public void add_onaction(ActionEvent actionEvent) {

        String Date = date.getPromptText();

        List<AttendansDto> attendanceDtoList = new ArrayList<>();
        for (AttendensTm attendansTm : obList) {
            String id = attendansTm.getId_tm();
            String name = attendansTm.getName_tm();
            boolean isPresent = attendansTm.isPresent();

            AttendansDto attendanceDto = new AttendansDto(Date, id, name, isPresent);
            attendanceDtoList.add(attendanceDto);
        }

        try {
            boolean isSuccess = AttendansModel.addAttendansList(attendanceDtoList);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attendans Save Success!").show();
                obList.clear();
                attendans_tm.setItems(obList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    private void setRemoveBtnAction(Button RemoveBtn, String Id) {

        RemoveBtn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {

                obList.removeIf(attendansTm -> attendansTm.getId_tm().equals(Id));
                attendans_tm.setItems(obList);
            }
        });
    }


    public void id_cobxOnAction(ActionEvent actionEvent) {
        String id = id_cobx.getValue();

        try {
            ManageEmployeeDto dto = ManageEmployeeModel.searchEmployee(id);
            lblName.setText(dto.getEmpname_txt());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllEmployee() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<ManageEmployeeDto> manageEmployeeDtos = ManageEmployeeModel.getAllEmployee();

            for (ManageEmployeeDto dto : manageEmployeeDtos) {
                obList.add(dto.getEmpid_txt());
            }
            id_cobx.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void mark_onaction(ActionEvent actionEvent) {

        String Id = id_cobx.getValue();
        String Name = lblName.getText();
        Button btn = new Button("Remove");

        setRemoveBtnAction(btn, Id);
        btn.setCursor(Cursor.HAND);

        if (!obList.isEmpty()) {
            for (int i = 0; i < attendans_tm.getItems().size(); i++) {
                if (id_tm.getCellData(i).equals(Id)) {

                    attendans_tm.refresh();
                    return;
                }
            }
        }
        var attendansTm = new AttendensTm(Id, Name, btn);

        obList.add(attendansTm);

        attendans_tm.setItems(obList);

    }
}
