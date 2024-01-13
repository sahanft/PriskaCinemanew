package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.Seat1Dto;
import lk.ijse.PriskaCinema.entity.Seat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SeatDao extends CrudDAO<Seat> {

   boolean save(Seat dto) throws SQLException, ClassNotFoundException;
   ArrayList<Seat> loadAll() throws SQLException, ClassNotFoundException;

   ArrayList<Seat> getAll() throws SQLException;
   boolean delete(Seat id) throws SQLException, ClassNotFoundException;
   boolean update(Seat dto) throws SQLException, ClassNotFoundException;


    /* Seat1Dto searchSeat(String id) throws SQLException;
*/





}
