package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MovieBo extends CrudDAO<ManageMoviesDto> {

    boolean save(ManageMoviesDto dto) throws SQLException, ClassNotFoundException;
    // boolean saveMovieIdAssociate(ProducerDetailsDto producerDetailsDto) throws SQLException ;


  List<ManageMoviesDto> loadAll() throws SQLException ;
     ArrayList<ManageMoviesDto> getAll() throws SQLException, ClassNotFoundException;

    boolean update(ManageMoviesDto Dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException ;





}
