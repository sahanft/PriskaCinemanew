package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ParkingDao extends CrudDAO<ManageParkingDto> {

    boolean save(ManageParkingDto dto) throws SQLException;

     List<ManageParkingDto> loadAll() throws SQLException;

  /* ArrayList<ManageParkingDto> getAllseat() throws SQLException ;
*/
   boolean delete(String id) throws SQLException;

   boolean update(ManageParkingDto dto) throws SQLException;

/*
     ManageParkingDto searchParking(String id) throws SQLException;
*/
}
