package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.SeatBo;
import lk.ijse.PriskaCinema.Dao.Custom.SeatDao;
import lk.ijse.PriskaCinema.Dao.Impl.SeatDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatBoImpl implements SeatBo {

  SeatDao seatDao = (SeatDao) new SeatDaoImpl();

    @Override
    public boolean save(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return seatDao.save(dto);
    }

    @Override
    public ArrayList<Seat1Dto> getAll() throws SQLException, ClassNotFoundException {
        return seatDao.getAll();
    }

    @Override
    public List<Seat1Dto> loadAll() throws SQLException {
        return seatDao.loadAll();
    }

    @Override
    public ArrayList<Seat1Dto> getAllseat() throws SQLException {
        return seatDao.getAllseat();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return seatDao.delete(id);
    }

    @Override
    public boolean update(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return seatDao.update(dto);
    }

    @Override
    public boolean delete(Seat1Dto seat1Dto) throws SQLException, ClassNotFoundException {
        return seatDao.delete(seat1Dto);
    }
}
