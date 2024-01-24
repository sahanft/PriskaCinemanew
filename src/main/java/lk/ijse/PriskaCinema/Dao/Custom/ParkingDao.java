package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;
import lk.ijse.PriskaCinema.entity.Parking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ParkingDao extends CrudDAO<Parking> {

    boolean save(Parking dto) throws SQLException, ClassNotFoundException;

     ArrayList<Parking> loadAll() throws SQLException, ClassNotFoundException;


   boolean delete(Parking id) throws SQLException, ClassNotFoundException;

   boolean update(Parking dto) throws SQLException, ClassNotFoundException;

}
