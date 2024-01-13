package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProducerBo extends SuperBo {

     boolean save(ManageProducerDto dto) throws SQLException, ClassNotFoundException;

    ArrayList<ManageProducerDto> loadAll() throws SQLException, ClassNotFoundException;

    ArrayList<ManageProducerDto> getAll() throws SQLException, ClassNotFoundException;

   boolean update(ManageProducerDto Dto) throws SQLException, ClassNotFoundException;


    boolean delete(ManageProducerDto id) throws SQLException, ClassNotFoundException;


}
