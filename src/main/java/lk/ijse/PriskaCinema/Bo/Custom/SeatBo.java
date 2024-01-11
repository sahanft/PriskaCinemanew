package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SeatBo extends CrudDAO<Seat1Dto> {

   boolean save(Seat1Dto dto) throws SQLException ;
   List<Seat1Dto> loadAll() throws SQLException ;

   ArrayList<Seat1Dto> getAllseat() throws SQLException;
   boolean delete(String id) throws SQLException;
   boolean update(Seat1Dto dto) throws SQLException;


    // Seat1Dto searchSeat(String id) throws SQLException;






}
