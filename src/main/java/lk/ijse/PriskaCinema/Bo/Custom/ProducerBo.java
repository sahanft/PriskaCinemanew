package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProducerBo extends CrudDAO<ManageProducerDto> {

     boolean saveProducer(ManageProducerDto dto) throws SQLException;

    List<ManageProducerDto> loadAllproducer() throws SQLException ;

    ArrayList<ManageProducerDto> getAllproducer() throws SQLException;

   boolean updateProducer(ManageProducerDto Dto) throws SQLException ;


    boolean deleteProducer(String id) throws SQLException;


}
