package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageHallDto;
import lk.ijse.PriskaCinema.entity.Hall;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface HallDao extends CrudDAO<Hall> {

     boolean save(Hall dto) throws SQLException, ClassNotFoundException;
     ArrayList<Hall> loadAll() throws SQLException, ClassNotFoundException;

     //ArrayList<ManageHallDto> getAllhall() throws SQLException;
    boolean update(Hall Dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

}



