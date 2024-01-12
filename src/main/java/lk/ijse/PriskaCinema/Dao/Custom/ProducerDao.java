package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProducerDao extends CrudDAO<ManageProducerDto> {


    boolean save(ManageProducerDto dto) throws SQLException, ClassNotFoundException;

    /*List<ManageProducerDto> loadAllproducer() throws SQLException ;*/

    ArrayList<ManageProducerDto> getAll() throws SQLException, ClassNotFoundException;

   boolean update(ManageProducerDto Dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException, ClassNotFoundException;
}
