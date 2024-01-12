package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface HallDao extends CrudDAO<ManageHallDto> {

     boolean save(ManageHallDto dto) throws SQLException, ClassNotFoundException;
     ArrayList<ManageHallDto> loadAll() throws SQLException, ClassNotFoundException;

     //ArrayList<ManageHallDto> getAllhall() throws SQLException;
    boolean update(ManageHallDto Dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

}



