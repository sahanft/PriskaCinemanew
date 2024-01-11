package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ParkingBo extends CrudDAO<ManageParkingDto> {

    boolean save(ManageParkingDto dto) throws SQLException, ClassNotFoundException;

     List<ManageParkingDto> loadAll() throws SQLException;

   ArrayList<ManageParkingDto> getAll() throws SQLException, ClassNotFoundException;

   boolean delete(String id) throws SQLException, ClassNotFoundException;

   boolean update(ManageParkingDto dto) throws SQLException, ClassNotFoundException;

    // ManageParkingDto searchParking(String id) throws SQLException;
}
