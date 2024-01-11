package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TicketBo extends CrudDAO<ManageTicketDto> {

    boolean save(ManageTicketDto dto) throws SQLException, ClassNotFoundException;

     List<ManageTicketDto> loadAll() throws SQLException ;

     ArrayList<ManageTicketDto> getAll() throws SQLException, ClassNotFoundException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;

     boolean update(ManageTicketDto dto) throws SQLException, ClassNotFoundException;

   // ManageTicketDto searchTicket(String id) throws SQLException ;

}
