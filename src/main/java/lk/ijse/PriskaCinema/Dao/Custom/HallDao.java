package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface HallDao extends CrudDAO<ManageHallDto> {

     boolean save(ManageHallDto dto) throws SQLException;
     List<ManageHallDto> loadAll() throws SQLException ;

     ArrayList<ManageHallDto> getAllhall() throws SQLException;
    boolean update(ManageHallDto Dto) throws SQLException;

    boolean delete(String id) throws SQLException ;

}



