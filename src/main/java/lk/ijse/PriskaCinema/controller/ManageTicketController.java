package lk.ijse.PriskaCinema.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
/*import jdk.internal.org.objectweb.asm.TypeReference;*/
import lk.ijse.PriskaCinema.Bo.BoFactory;
import lk.ijse.PriskaCinema.Bo.Custom.EmployeeBo;
import lk.ijse.PriskaCinema.Bo.Custom.TicketBo;
import lk.ijse.PriskaCinema.Bo.Impl.TicketBoImpl;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;
import lk.ijse.PriskaCinema.tm.TicketTm;
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

public class ManageTicketController implements Initializable {
    public TextField screen_txt;
    public TextField movieid_txt;
    public TextField tickettype_txt;
    public TextField price_txt;
    public TextField empid_txt;
    public TextField time_txt;


    public TextField ticketnumber_txt;
    public TableView <TicketTm> manageticket_tm;
    public TableColumn <?,?> ticketnum_tm;
    public TableColumn <?,?> type_tm;
    public TableColumn <?,?> id_tm;
    public TableColumn <?,?> screen_tm;
    public TableColumn <?,?> price_tm;
    public TableColumn <?,?> empid_tm;
    public TableColumn <?,?> time_tm;
    public TableColumn <?,?> date_tm;
    public DatePicker  date;
    public DatePicker date_txt;
    public Label lbltickettotal;
    private String tNum;

    TicketBo ticketBo = (TicketBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.TICKET);
    private TicketTm newValue;

    public void initialize() {
        setCellValueFactory();
        loadAllTicket();
        tableListener();
        clearField();
    }
    public void add_onaction(ActionEvent actionEvent) {

        String ticketNum = ticketnumber_txt.getText();
        String tickettype = tickettype_txt.getText();
        String movieid= movieid_txt.getText();
        String screen= screen_txt.getText();
        Double price= Double.valueOf(price_txt.getText());
        String empid= empid_txt.getText();
        String  time= time_txt.getText();
        LocalDate Date = date_txt.getValue();






        var dto = new ManageTicketDto(ticketNum,tickettype,movieid,screen,price,empid,time,Date);

        try {
            boolean isSaved = ticketBo.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "vehicle Save").show();
                loadAllTicket();
                clearField();
                totalTicket();
            }
            manageticket_tm.getItems().add(new TicketTm(ticketNum,tickettype,movieid,screen,price,empid,time,Date));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        manageticket_tm.refresh();


        }

    private void clearField(){
        ticketnumber_txt.clear();
        tickettype_txt.clear();
        movieid_txt.clear();
        screen_txt.clear();
        price_txt.clear();
        empid_txt.clear();
        time_txt.clear();

    }

    private void loadAllTicket() {
        manageticket_tm.getItems().clear();

       // ObservableList<TicketTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageTicketDto> dtoList = (ArrayList<ManageTicketDto>) ticketBo.loadAll();

            for (ManageTicketDto dto : dtoList) {
                //obList.add(
                manageticket_tm.getItems().addAll(


                        new TicketTm(
                                dto.getTicketnumber_txt(),
                                dto.getTickettype_txt(),
                                dto.getMovieid_txt(),
                                dto.getScreen_txt(),
                                dto.getPrice_txt(),
                                dto.getEmpid_txt(),
                                dto.getTime_txt(),
                                dto.getDate_txt()

                        ));
            }

          //  manageticket_tm.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        ticketnum_tm.setCellValueFactory(new PropertyValueFactory<>("ticketNum"));
        type_tm.setCellValueFactory(new PropertyValueFactory<>("tickettype"));
        id_tm.setCellValueFactory(new PropertyValueFactory<>("movieid"));
        screen_tm.setCellValueFactory(new PropertyValueFactory<>("screen"));
        price_tm.setCellValueFactory(new PropertyValueFactory<>("price"));
        empid_tm.setCellValueFactory(new PropertyValueFactory<>("empid"));
        time_tm.setCellValueFactory(new PropertyValueFactory<>("time"));
        date_tm.setCellValueFactory(new PropertyValueFactory<>("date"));


    }
    private void setData(TicketTm row) {
//        ticketnum_tm.setText(row.getTicketNum());
//        type_tm.setText(row.getTickettype());
//        id_tm.setText(row.getMovieid());
//        screen_tm.setText(row.getScreen());
//        price_tm.setText(row.getPrice());
//        empid_tm.setText(row.getEmpid());
//        time_tm.setText(row.getTime());
//        date_tm.setText(String.valueOf(row.getDate()));
    }
    public void tableListener(){
        manageticket_tm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
            this.newValue = newValue;

        });
    }

    public void update_onaction(ActionEvent actionEvent) {

        String tnumber = ticketnumber_txt.getText();
        String type = tickettype_txt.getText();
        String movieid = movieid_txt.getText();
        String screen = screen_txt.getText();
        Double price = Double.parseDouble(price_txt.getText());
        String empid = empid_txt.getText();
        String time = time_txt.getText();

        LocalDate date =  date_txt.getValue();


        try {

            var dto = new ManageTicketDto(tnumber, type,movieid,screen,price,empid,time,date);
            boolean isUpdated = ticketBo.update(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "ticket details updated").show();;
                clearField();
                loadAllTicket();
                totalTicket();
            } else {
                new Alert(Alert.AlertType.ERROR, "ticket details not updated").show();;
            }
            manageticket_tm.getItems().add(new TicketTm(tnumber,type,movieid,screen,price,empid,time,date));

        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            clearField();
        }
    }






    public void delete_onaction(ActionEvent actionEvent) {

        String id = ticketnumber_txt.getText();
        ManageTicketDto dto = new ManageTicketDto(id);

        try{
            boolean isDelete = ticketBo.delete(dto);
            if (isDelete){
                manageticket_tm.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION,"ticket delete").show();
                loadAllTicket();
                clearField();
                totalTicket();
            }else{
                new Alert(Alert.AlertType.ERROR,"ticket not delete").show();
            }
            manageticket_tm.getItems().remove(manageticket_tm.getSelectionModel().getSelectedItem());
            loadAllTicket();
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void btnPrintOnAction(ActionEvent event) throws JRException, SQLException {

        HashMap map = new HashMap<>();
        map.put("id", newValue.getTicketNum());
        //map.put("id", newValue.getMovieid());
        map.put("price", newValue.getPrice());
        map.put("type", newValue.getTickettype());
        map.put("time", newValue.getTime());

        InputStream resourceAsStream =
               getClass().getResourceAsStream("../report/Landscape.jrxml");
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

    public void totalTicket() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT SUM(price) FROM ticket";

        double totalInCome = 0;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                totalInCome = resultSet.getDouble("SUM(price)");

            }
          
            lbltickettotal.setText("Rs. " + totalInCome);
            loadAllTicket();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            totalTicket();
            setCellValueFactory();
            loadAllTicket();
            tableListener();
            clearField();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
