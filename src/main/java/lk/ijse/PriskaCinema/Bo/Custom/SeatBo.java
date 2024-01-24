package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SeatBo extends SuperBo {

   boolean save(Seat1Dto dto) throws SQLException, ClassNotFoundException;
   List<Seat1Dto> loadAll() throws SQLException, ClassNotFoundException;

   ArrayList<Seat1Dto> getAll() throws SQLException;
   boolean delete(Seat1Dto id) throws SQLException, ClassNotFoundException;
   boolean update(Seat1Dto dto) throws SQLException, ClassNotFoundException;








}
