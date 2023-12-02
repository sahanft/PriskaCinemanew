package lk.ijse.PriskaCinema.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.PriskaCinema.dto.ExpenditureDto;
import lk.ijse.PriskaCinema.dto.IncomeDto;
import lk.ijse.PriskaCinema.model.ExpenditureModel;
import lk.ijse.PriskaCinema.model.IncomeModel;
import lk.ijse.PriskaCinema.tm.ExpenditureTm;
import lk.ijse.PriskaCinema.tm.IncomeTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ManagePaymentController {
    public TableView income_tm;
    public TableColumn<?, ?> id_tm;
    public TableColumn<?, ?> description_tm;
    public TableColumn<?, ?> month_tm;
    public TableColumn<?, ?> amount_tm;
    public TextField description_txt2;
    public TextField month_txt2;
    public TextField amount_txt2;
    public TableView expenditure_tm;
    public TableColumn<?, ?> id_tm2;
    public TableColumn<?, ?> description_tm2;
    public TableColumn<?, ?> month_tm2;
    public TableColumn<?, ?> amount_tm2;
    public TextField expenditure_txt;
    public TextField income_txt;
    public TextField month_txt;
    public TextField amount_txt;
    public TextField discription_txt;

    private IncomeModel incomeModel = new IncomeModel();
 private ExpenditureModel expenditureModel = new ExpenditureModel();
    private Object newValue;


    public void initialize() {
        setCellValueFactory();
      //  setCellValuefactory();
        clearField();
     //   clearfield();
        loadAllIncome();
      //  loadAllExpenditure();
        tableListener();
      //  tablelistener();


    }

    private void loadAllIncome() {

        ObservableList<IncomeTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<IncomeDto> dtoList = (ArrayList<IncomeDto>) incomeModel.loadAllincome();

            for (IncomeDto dto : dtoList) {
                obList.add(
                        new IncomeTm(
                                dto.getIncome_txt(),
                                dto.getDescription_txt(),
                                dto.getMonth_txt(),
                                dto.getAmount_txt()


                        ));
            }

            income_tm.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void clearField() {
        income_txt.setText("");
        discription_txt.setText("");
        month_txt.setText("");
        amount_txt.setText("");


    }

 private void loadAllExpenditure() {

        ObservableList<ExpenditureTm> obList = FXCollections.observableArrayList();

        try {


            ArrayList<ExpenditureDto> dtoList = (ArrayList<ExpenditureDto>) expenditureModel.loadAllexpenditure();

            for (ExpenditureDto dto : dtoList) {
                obList.add(
                        new ExpenditureTm(
                                dto.getExpenditure_txt(),
                                dto.getDescription2_txt(),
                                dto.getMonth2_txt(),
                                dto.getAmount2_txt()


                        ));
            }

            income_tm.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


 private void clearfield() {
        expenditure_txt.setText("");
        description_txt2.setText("");
        month_txt2.setText("");
        amount_txt2.setText("");


    }


    private void setCellValueFactory() {
        id_tm.setCellValueFactory(new PropertyValueFactory<>("id"));
        description_tm.setCellValueFactory(new PropertyValueFactory<>("description"));
        month_tm.setCellValueFactory(new PropertyValueFactory<>("month"));
        amount_tm.setCellValueFactory(new PropertyValueFactory<>("amount"));


    }

 private void setCellValuefactory() {
        id_tm2.setCellValueFactory(new PropertyValueFactory<>("id2"));
        description_tm2.setCellValueFactory(new PropertyValueFactory<>("description2"));
        month_tm2.setCellValueFactory(new PropertyValueFactory<>("month2"));
        amount_tm2.setCellValueFactory(new PropertyValueFactory<>("amount2"));


    }


    private void setData(IncomeTm row) {
        id_tm.setText(row.getId());
       description_tm.setText(row.getDescription());
       month_tm.setText(row.getMonth());
      amount_tm.setText(String.valueOf(row.getAmount()));


    }

 private void setdata(ExpenditureTm row) {
       id_tm2.setText(row.getId2());
       description_tm2.setText(row.getDescription2());
       month_tm2.setText(row.getMonth2());
        amount_tm2.setText(String.valueOf(row.getAmount2()));


    }


    public void tableListener() {
        income_tm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData((IncomeTm) newValue);

        });
    }

  public void tablelistener() {
        expenditure_tm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setdata((ExpenditureTm) newValue);
            this.newValue = newValue;
        });
    }




 public void delete_onaction2(ActionEvent actionEvent) {

        String id = expenditure_txt.getText();


        try {
            boolean isDelete = ExpenditureModel.deleteExpenditure(id);
            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "expenditure details are deleted").show();
                loadAllExpenditure();
                clearfield();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "expenditure details are not deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void add_onaction2(ActionEvent actionEvent) {

        String income2 = income_txt.getText();
        String description2 = discription_txt.getText();
        String month2 = month_txt.getText();
        String  amount2 = amount_txt.getText();




/* if *//*(!validateIncome()){
                return;
            }*/

            var dto = new ExpenditureDto(income2, description2, month2, amount2);
            try {
            boolean isSaved = ExpenditureModel.saveExpenditure(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "expenditure detail Save").show();
                loadAllExpenditure();
                clearfield();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        expenditure_tm.refresh();

    }




    public void add_onaction(ActionEvent actionEvent) {

        String income = income_txt.getText();
        String description = discription_txt.getText();
        String month = month_txt.getText();
        double amount = Double.parseDouble(amount_txt.getText());



 /*if (!validateIncome()){
                return;
            }*/


            var dto = new IncomeDto(income, description, month, amount);
        try {
            boolean isSaved = IncomeModel.saveIncome(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "income detail Save").show();
                loadAllIncome();
                clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        income_tm.refresh();


    }

    public void delete_onaction(ActionEvent actionEvent) {

        String id = income_txt.getText();

        try {
            boolean isDelete = IncomeModel.deleteIncome(id);
            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "income details are deleted").show();
                loadAllIncome();
                clearField();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "income details are not deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
