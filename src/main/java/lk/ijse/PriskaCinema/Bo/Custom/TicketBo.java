package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TicketBo extends SuperBo {

    boolean save(ManageTicketDto dto) throws SQLException, ClassNotFoundException;

     List<ManageTicketDto> loadAll() throws SQLException, ClassNotFoundException;

     ArrayList<ManageTicketDto> getAll() throws SQLException, ClassNotFoundException;
     boolean delete(ManageTicketDto id) throws SQLException, ClassNotFoundException;

     boolean update(ManageTicketDto dto) throws SQLException, ClassNotFoundException;


}
