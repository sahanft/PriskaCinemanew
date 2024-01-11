package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProducerBo extends CrudDAO<ManageProducerDto> {

     boolean save(ManageProducerDto dto) throws SQLException;

    List<ManageProducerDto> loadAll() throws SQLException ;

    ArrayList<ManageProducerDto> getAll() throws SQLException;

   boolean update(ManageProducerDto Dto) throws SQLException ;


    boolean delete(String id) throws SQLException;


}
