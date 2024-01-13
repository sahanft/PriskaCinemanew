package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MovieBo extends SuperBo {

    boolean save(ManageMoviesDto dto) throws SQLException, ClassNotFoundException;
    // boolean saveMovieIdAssociate(ProducerDetailsDto producerDetailsDto) throws SQLException ;


  List<ManageMoviesDto> loadAll() throws SQLException, ClassNotFoundException;
     ArrayList<ManageMoviesDto> getAll() throws SQLException, ClassNotFoundException;

    boolean update(ManageMoviesDto Dto) throws SQLException, ClassNotFoundException;

    boolean delete(ManageMoviesDto id) throws SQLException, ClassNotFoundException;
    boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException, ClassNotFoundException;

    boolean saveMovie(ManageMoviesDto dto) throws SQLException, ClassNotFoundException;
}
