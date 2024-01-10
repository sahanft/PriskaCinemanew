package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProducerDao extends CrudDAO<ManageProducerDto> {

     boolean save(ManageProducerDto dto) throws SQLException;

    /*List<ManageProducerDto> loadAllproducer() throws SQLException ;*/

    ArrayList<ManageProducerDto> getAll() throws SQLException;

   boolean update(ManageProducerDto Dto) throws SQLException ;


    boolean delete(String id) throws SQLException;


}
