package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TicketBo extends CrudDAO<ManageTicketDto> {

    boolean saveTicket(ManageTicketDto dto) throws SQLException ;

     List<ManageTicketDto> loadAllparking() throws SQLException ;

     ArrayList<ManageTicketDto> getAllseat() throws SQLException;
     boolean deleteTicket(String id) throws SQLException;

     boolean updateTicket(ManageTicketDto dto) throws SQLException ;

    ManageTicketDto searchTicket(String id) throws SQLException ;

}
