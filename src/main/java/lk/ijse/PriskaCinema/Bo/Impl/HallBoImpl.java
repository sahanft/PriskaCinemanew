package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.HallBo;
import lk.ijse.PriskaCinema.Dao.Custom.HallDao;
import lk.ijse.PriskaCinema.Dao.Impl.HallDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallBoImpl implements HallBo {

    HallDao hallDao = (HallDao) new HallDaoImpl();

    @Override
    public boolean save(ManageHallDto dto) throws SQLException, ClassNotFoundException {
        return hallDao.save(dto);
    }

    @Override
    public List<ManageHallDto> loadAll() throws SQLException {
        return hallDao.loadAll();
    }

    @Override
    public ArrayList<ManageHallDto> getAll() throws SQLException, ClassNotFoundException {
        return hallDao.getAll();
    }

    @Override
    public boolean update(ManageHallDto Dto) throws SQLException, ClassNotFoundException {
        return hallDao.update(Dto);
    }

    @Override
    public boolean delete(ManageHallDto manageHallDto) throws SQLException, ClassNotFoundException {
        return hallDao.delete(manageHallDto);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return hallDao.delete(id);
    }
}



