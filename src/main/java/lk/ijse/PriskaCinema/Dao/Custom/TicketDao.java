package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface TicketDao extends CrudDAO<ManageTicketDto> {

    boolean save(ManageTicketDto dto) throws SQLException, ClassNotFoundException;

     ArrayList<ManageTicketDto> loadAll() throws SQLException, ClassNotFoundException;

     //ArrayList<ManageTicketDto> getAllseat() throws SQLException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;

     boolean update(ManageTicketDto dto) throws SQLException, ClassNotFoundException;

  /*  ManageTicketDto searchTicket(String id) throws SQLException ;
*/
}
