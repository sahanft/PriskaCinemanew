package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface HallBo extends CrudDAO<ManageHallDto> {

     boolean saveHall(ManageHallDto dto) throws SQLException;
     List<ManageHallDto> loadAllhall() throws SQLException ;

     ArrayList<ManageHallDto> getAllhall() throws SQLException;
    boolean updateHall(ManageHallDto Dto) throws SQLException;

    boolean deleteHall(String id) throws SQLException ;

}



