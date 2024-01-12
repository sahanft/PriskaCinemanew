package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ParkingDao extends CrudDAO<ManageParkingDto> {

    boolean save(ManageParkingDto dto) throws SQLException, ClassNotFoundException;

     ArrayList<ManageParkingDto> loadAll() throws SQLException, ClassNotFoundException;

  /* ArrayList<ManageParkingDto> getAllseat() throws SQLException ;
*/
   boolean delete(String id) throws SQLException, ClassNotFoundException;

   boolean update(ManageParkingDto dto) throws SQLException, ClassNotFoundException;

/*
     ManageParkingDto searchParking(String id) throws SQLException;
*/
}
