package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface HallBo extends SuperBo {

     boolean save(ManageHallDto dto) throws SQLException, ClassNotFoundException;
     List<ManageHallDto> loadAll() throws SQLException, ClassNotFoundException;

     ArrayList<ManageHallDto> getAll() throws SQLException, ClassNotFoundException;
    boolean update(ManageHallDto Dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

}



