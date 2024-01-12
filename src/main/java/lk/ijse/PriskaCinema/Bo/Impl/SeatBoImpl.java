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

  SeatDao seatDao = new SeatDaoImpl();

    @Override
    public boolean save(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return seatDao.save(dto);
    }


    @Override
    public List<Seat1Dto> loadAll() throws SQLException, ClassNotFoundException {
        return seatDao.loadAll();
    }

    @Override
    public ArrayList<Seat1Dto> getAll() throws SQLException {
        return seatDao.getAll();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return seatDao.delete(id);
    }

    @Override
    public boolean update(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return seatDao.update(dto);
    }


}
