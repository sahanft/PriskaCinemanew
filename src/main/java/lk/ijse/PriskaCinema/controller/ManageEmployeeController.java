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
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.model.ManageEmployeeModel;
import lk.ijse.PriskaCinema.model.ManageProducerModel;
import lk.ijse.PriskaCinema.tm.EmployeeTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.controlsfx.control.Notifications;

public class ManageEmployeeController {
    public TableColumn <?,?> empname_tbl;
    public TableColumn <?,?> empadress_tbl;
    public TableColumn <?,?> empmobile_tbl;
    public TableColumn <?,?> empjobtype_tbl;
    public TableColumn <?,?> empnic_tbl;
    public TableColumn <?,?> empid_tbl;
    public TableColumn <?,?> empsalary_tbl;

    public TextField name_txt;
    public TextField mobilenumber_txt;
    public TextField address_txt;
    public TextField jobtype_txt;
    public TextField employeeid_txt;
    public TextField nic_txt;
    public TextField salary_txt;
    public AnchorPane root3;
    public TableView<EmployeeTm> tmEmployee;

    private ManageEmployeeModel manageEmployeeModel = new ManageEmployeeModel();

    public void initialize() {
        setCellValueFactory();
        clearField();
        loadAllemployee();
        //setData();
    }

    private void clearField() {
        employeeid_txt.setText("");
        name_txt.setText("");
        jobtype_txt.setText("");
        mobilenumber_txt.setText("");
        nic_txt.setText("");
        salary_txt.setText("");
        address_txt.setText("");

    }





    public void manageempadd_onaction(ActionEvent actionEvent) {

    }

    public void manageempdelete_onaction(ActionEvent actionEvent) {

    }


   

    public void update_onaction(ActionEvent actionEvent) {

        String id = employeeid_txt.getText();
        String name = name_txt.getText();
        String jobtype = jobtype_txt.getText();
        String mobile =String.valueOf(mobilenumber_txt.getText());
        String nic = nic_txt.getText();
        Double salary = Double.parseDouble(salary_txt.getText());
        String address= address_txt.getText();


        var dto = new ManageEmployeeDto(id, name, jobtype,mobile,nic,salary,address);

     var model = new ManageEmployeeModel();
        try {
            boolean isUpdated = ManageEmployeeModel.updateEmployee(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                //clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    public void add_onaction(ActionEvent actionEvent) {
        String id = employeeid_txt.getText();
        String name = name_txt.getText();
        String jobtype = jobtype_txt.getText();
        String mobile = String.valueOf(mobilenumber_txt.getText());
        String nic = nic_txt.getText();
      //  Double salary = Double.parseDouble(salary_txt.getText());
        double salary = Double.parseDouble(salary_txt.getText());
        String address = address_txt.getText();

      //  var dto = new ManageEmployeeDto(id,name,jobtype,mobile,nic,salary,address);

        try {
            if (!validateEmployee()){
                return;
            }

            var dto = new ManageEmployeeDto(id,name,jobtype,mobile,nic,salary,address);

            boolean isSaved = ManageEmployeeModel.saveEmployee(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer Save").show();
                loadAllemployee();
                clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
        tmEmployee.refresh();

    }

    private void loadAllemployee() {

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageEmployeeDto> dtoList = (ArrayList<ManageEmployeeDto>) manageEmployeeModel.loadAllemployee();

            for (ManageEmployeeDto dto : dtoList) {
                obList.add(
                        new EmployeeTm(
                                dto.getEmpid_txt(),
                                dto.getEmpname_txt(),
                                dto.getEmpjobtype_txt(),
                                dto.getEmpmobile_txt(),
                                dto.getEmpnic_txt(),
                                dto.getEmpsalary_txt(),
                                dto.getEmpaddress_txt()

                        ));
            }

            tmEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        empid_tbl.setCellValueFactory(new PropertyValueFactory<>("empid"));
        empname_tbl.setCellValueFactory(new PropertyValueFactory<>("empname"));
        empjobtype_tbl.setCellValueFactory(new PropertyValueFactory<>("jobtype"));
        empmobile_tbl.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        empnic_tbl.setCellValueFactory(new PropertyValueFactory<>("nic"));
        empsalary_tbl.setCellValueFactory(new PropertyValueFactory<>("salary"));
        empadress_tbl.setCellValueFactory(new PropertyValueFactory<>("address"));

          }
    private void setData(EmployeeTm row) {
        empid_tbl.setText(row.getEmpid());
        empname_tbl.setText(row.getEmpname());
        empjobtype_tbl.setText(row.getJobtype());
        empmobile_tbl.setText(String.valueOf(row.getMobile()));
        empnic_tbl.setText(row.getNic());
        empsalary_tbl.setText(String.valueOf(row.getSalary()));
        empadress_tbl.setText(row.getAddress());

    }
    public void tableListener(){
        tmEmployee.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData((EmployeeTm) newValue);
        });
    }




    public void delete_onaction(ActionEvent actionEvent) {
        String id = employeeid_txt.getText();

        try{
            boolean isDelete = ManageEmployeeModel.deleteEmployee(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"customer delete").show();
                loadAllemployee();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void attendans_onaction(ActionEvent actionEvent) throws IOException {

        root3.getChildren().clear();
        root3.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "attendans.fxml")));


    }

  /*  public void print_onaction(ActionEvent actionEvent) {

    }*/

    private boolean validateEmployee() {
        boolean isValidate = true;
       /* if (!Pattern.matches("\\b[A-Z][a-z]( [A-Z][a-z])*\\b", txtName.getText())) {
            showErrorNotification("Invalid Employee Name", "The employee name you entered is invalid");
            isValidate = false;
        }*/
        boolean name = Pattern.matches("[A-Za-z]{5,}", name_txt.getText());
        if (!name){
            showErrorNotification("Invalid Employee Name", "The Employee name you entered is invalid");
            isValidate = false;
        }
        boolean con = Pattern.matches("[0-9]{10,}",mobilenumber_txt.getText());
        if (!con){
            showErrorNotification("Invalid Contact Number", "The contact number you entered is invalid");
            isValidate = false;
        }
        boolean NIC = Pattern.matches("^([0-9]{9}|[0-9]{12})$",nic_txt.getText());
        if (!NIC){
            showErrorNotification("Invalid NIC", "The NUC Number you entered is invalid");
            isValidate = false;

        }
        boolean Job = Pattern.matches("[A-Za-z]{5,}",jobtype_txt.getText());
        if (!Job){
            showErrorNotification("Invalid job type", "The job type you entered is invalid");
            isValidate = false;
        }
        return isValidate;
    }

    private void showErrorNotification(String title, String text) {
        Notifications.create()
                .title(title)
                .text(text)
                .showError();
    }

    public void print_onaction(ActionEvent actionEvent) {
    }
}
