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
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.model.ManageMoviesModel;
import lk.ijse.PriskaCinema.model.ManageProducerModel;
import lk.ijse.PriskaCinema.tm.MovieTm;
import lk.ijse.PriskaCinema.tm.ProducerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMoviesController {
    public AnchorPane movieroot;
    public TableView movie_tm;
    public TableColumn id_tm;
    public TableColumn name_tm;
    public TableColumn genre_tm;
    public TableColumn duration_tm;
    public TableColumn time_tm;
    public TextField id_txt;
    public TextField name_txt;
    public TextField genre_txt;
    public TextField duration_txt;
    public TextField time_txt;

    private ManageMoviesModel manageMoviesModel = new ManageMoviesModel();

    public void initialize() {
        setCellValueFactory();
        clearField();
        loadAllmovie();

    }

    private void clearField() {
        id_txt.setText("");
        name_txt.setText("");
        genre_txt.setText("");
        duration_txt.setText("");
    }

    public void next_onaction(ActionEvent actionEvent) throws IOException {

        movieroot.getChildren().clear();
        movieroot.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "managehall.fxml")));

    }

    public void back_onaction(ActionEvent actionEvent) throws IOException {

        movieroot.getChildren().clear();
        movieroot.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" + "manageproducer.fxml")));



    }

    public void add_onaction(ActionEvent actionEvent) {

        String id = id_txt.getText();
        String name = name_txt.getText();
        String genre = genre_txt.getText();
        String duration = duration_txt.getText();
        String time = time_txt.getText();

        var dto = new ManageMoviesDto(id,name,genre,duration,time);

        try {
            boolean isSaved = ManageMoviesModel.saveMovie(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Movie Save").show();
                loadAllmovie();
                clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        }
        movie_tm.refresh();

    }


    private void loadAllmovie() {

        ObservableList<MovieTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<ManageMoviesDto> dtoList = (ArrayList<ManageMoviesDto>) manageMoviesModel.loadAllmovie();

            for (ManageMoviesDto dto : dtoList) {
                obList.add(
                        new MovieTm(
                                dto.getId_txt(),
                                dto.getName_txt(),
                                dto.getGenre_txt(),
                                dto.getDuration_txt(),
                                dto.getTime_txt()


                        ));
            }

            movie_tm.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        id_tm.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_tm.setCellValueFactory(new PropertyValueFactory<>("name"));
        genre_tm.setCellValueFactory(new PropertyValueFactory<>("genre"));
        duration_tm.setCellValueFactory(new PropertyValueFactory<>("duration"));
        time_tm.setCellValueFactory(new PropertyValueFactory<>("time"));


    }
    private void setData(MovieTm row) {
        id_txt.setText(row.getId());
        name_txt.setText(row.getName());
        genre_txt.setText(row.getGenre());
        duration_txt.setText(row.getDuration());
        time_txt.setText(row.getTime());



    }
    public void tableListener(){
        movie_tm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData((MovieTm) newValue);
        });
    }











    public void update_onaction(ActionEvent actionEvent) {

    }

    public void delete_onaction(ActionEvent actionEvent) {

        String id = id_txt.getText();

//        var model = new CustomerModel();
        try {
            boolean isDeleted = ManageMoviesModel.deleteMovie(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "movie deleted!").show();
                loadAllmovie();

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "movie not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


}
