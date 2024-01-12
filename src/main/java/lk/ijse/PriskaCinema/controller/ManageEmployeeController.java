package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.PriskaCinema.Bo.Custom.EmployeeBo;
import lk.ijse.PriskaCinema.Bo.Impl.EmployeeBoImpl;
import lk.ijse.PriskaCinema.dto.employeeDto;
import lk.ijse.PriskaCinema.tm.EmployeeTm;

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


    EmployeeBo employeeBo = new EmployeeBoImpl();

    public void initialize() {
        setCellValueFactory();
        clearField();
        loadAllemployee();
        tableListener();

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


    public void update_onaction(ActionEvent actionEvent) {
        String id = employeeid_txt.getText();
        String name = name_txt.getText();
        String jobtype = jobtype_txt.getText();
        String mobile = mobilenumber_txt.getText();
        String nic = nic_txt.getText();
        String salary =salary_txt.getText();
        String address= address_txt.getText();

        try {
            if (!validateEmployee()) {
                return;
            }
            clearField();
            var dto = new employeeDto(id, name, jobtype,mobile,nic, Double.valueOf(salary),address);
            boolean isUpdated = employeeBo.update(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee details updated").show();;
                clearField();
                loadAllemployee();
            } else {
                new Alert(Alert.AlertType.ERROR, "Employee details not updated").show();;
            }
            tmEmployee.getItems().add(new EmployeeTm(id,name,jobtype,mobile,nic,Double.parseDouble(salary),address));
            loadAllemployee();

        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            clearField();
        }



}

    private void clearFields() {
    }

    public void add_onaction(ActionEvent actionEvent) {
        String id = employeeid_txt.getText();
        String name = name_txt.getText();
        String jobtype = jobtype_txt.getText();
        String mobile = String.valueOf(mobilenumber_txt.getText());
        String nic = nic_txt.getText();
        double salary = Double.parseDouble(salary_txt.getText());
        String address = address_txt.getText();



        try {
            if (!validateEmployee()){
                return;
            }

            var dto = new employeeDto(id,name,jobtype,mobile,nic,salary,address);

            boolean isSaved = employeeBo.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer Save").show();
                loadAllemployee();
                clearField();
            }
            tmEmployee.getItems().add(new EmployeeTm(id,name,jobtype,mobile,nic,salary,address));
            loadAllemployee();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tmEmployee.refresh();

    }

    private void loadAllemployee() {
        tmEmployee.getItems().clear();

        try {
            ArrayList<employeeDto> dtoList = (ArrayList<employeeDto>) employeeBo.loadAll();

            for (employeeDto dto : dtoList) {
                tmEmployee.getItems().addAll(
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

            //tmEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
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
     /*   empid_tbl.setText(row.getEmpid());
        empname_tbl.setText(row.getEmpname());
        empjobtype_tbl.setText(row.getJobtype());
        empmobile_tbl.setText(String.valueOf(row.getMobile()));
        empnic_tbl.setText(row.getNic());
        empsalary_tbl.setText(String.valueOf(row.getSalary()));
        empadress_tbl.setText(row.getAddress());
*/
    }
    public void tableListener(){
        tmEmployee.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData((EmployeeTm) newValue);
        });
    }




    public void delete_onaction(ActionEvent actionEvent) {
        String id = employeeid_txt.getText();

        try{

            boolean isDelete = employeeBo.delete(id);

            if (isDelete){
                tmEmployee.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION,"employee delete").show();
                loadAllemployee();
                clearField();
            } else {
                new Alert(Alert.AlertType.ERROR,"employee not delete").show();
            }
            tmEmployee.getItems().remove(tmEmployee.getSelectionModel().getSelectedItem());
            loadAllemployee();

        }catch (SQLException | ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }




    private boolean validateEmployee() {
        boolean isValidate = true;

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
