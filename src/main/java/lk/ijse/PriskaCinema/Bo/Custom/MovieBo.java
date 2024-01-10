package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MovieBo extends CrudDAO<ManageMoviesDto> {

    boolean saveMovie(ManageMoviesDto dto) throws SQLException ;
     boolean saveMovieIdAssociate(ProducerDetailsDto producerDetailsDto) throws SQLException ;


  List<ManageMoviesDto> loadAllmovie() throws SQLException ;
     ArrayList<ManageMoviesDto> getAllmovie() throws SQLException;

    boolean updateMovie(ManageMoviesDto Dto) throws SQLException ;

    boolean deleteMovie(String id) throws SQLException;
    boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException ;





}
