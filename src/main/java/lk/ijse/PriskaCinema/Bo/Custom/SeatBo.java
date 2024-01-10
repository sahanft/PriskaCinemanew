package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SeatBo extends CrudDAO<Seat1Dto> {

   boolean saveSeat(Seat1Dto dto) throws SQLException ;
   List<Seat1Dto> loadAllseat() throws SQLException ;

   ArrayList<Seat1Dto> getAllseat() throws SQLException;
   boolean deleteSeat(String id) throws SQLException;
   boolean updateSeat(Seat1Dto dto) throws SQLException;


     Seat1Dto searchSeat(String id) throws SQLException;






}
