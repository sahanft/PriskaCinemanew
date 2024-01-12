package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;
import lk.ijse.PriskaCinema.entity.Producer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProducerDao extends CrudDAO<Producer> {


    boolean save(Producer dto) throws SQLException, ClassNotFoundException;

    /*List<ManageProducerDto> loadAllproducer() throws SQLException ;*/

    ArrayList<Producer> getAll() throws SQLException, ClassNotFoundException;

   boolean update(Producer Dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean saveProducerMovieDetails(Producer producerDetailsDto) throws SQLException, ClassNotFoundException;
}
