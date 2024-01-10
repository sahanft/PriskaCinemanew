package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ParkingBo extends CrudDAO<ManageParkingDto> {

    boolean saveParking(ManageParkingDto dto) throws SQLException;

     List<ManageParkingDto> loadAllparking() throws SQLException;

   ArrayList<ManageParkingDto> getAllseat() throws SQLException ;

   boolean deleteParking(String id) throws SQLException;

   boolean updateParking(ManageParkingDto dto) throws SQLException;

     ManageParkingDto searchParking(String id) throws SQLException;
}
