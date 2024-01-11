package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.ParkingBo;
import lk.ijse.PriskaCinema.Dao.Custom.ParkingDao;
import lk.ijse.PriskaCinema.Dao.Impl.ParkingDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingBoImpl implements ParkingBo {

    ParkingDao parkingDao = new ParkingDaoImpl();


    @Override
    public boolean save(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return parkingDao.save(dto);
    }

    @Override
    public List<ManageParkingDto> loadAll() throws SQLException {
        return parkingDao.loadAll();
    }

    @Override
    public ArrayList<ManageParkingDto> getAll() throws SQLException, ClassNotFoundException {
        return parkingDao.getAll();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return parkingDao.delete(id);
    }

    @Override
    public boolean update(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return parkingDao.update(dto);
    }

    @Override
    public boolean delete(ManageParkingDto manageParkingDto) throws SQLException, ClassNotFoundException {
        return parkingDao.delete(manageParkingDto);
    }
}
