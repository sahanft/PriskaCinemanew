package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.HallBo;
import lk.ijse.PriskaCinema.Dao.Custom.HallDao;
import lk.ijse.PriskaCinema.Dao.Impl.HallDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageHallDto;
import lk.ijse.PriskaCinema.entity.Hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallBoImpl implements HallBo {

    HallDao hallDao = new HallDaoImpl();

    @Override
    public boolean save(ManageHallDto dto) throws SQLException, ClassNotFoundException {
        return hallDao.save(new Hall(dto.getNumber_txt(), dto.getCategory_txt(), dto.getCount_txt()));
    }

    @Override
    public List<ManageHallDto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Hall> entityList = hallDao.loadAll();
        ArrayList<ManageHallDto> dtoList = new ArrayList<>();

        for (Hall entity : entityList) {
            dtoList.add(new ManageHallDto(
                    entity.getNumber_txt(),
                    entity.getCategory_txt(),
                    entity.getCount_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public ArrayList<ManageHallDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Hall> entityList = hallDao.getAll();
        ArrayList<ManageHallDto> dtoList = new ArrayList<>();
        for (Hall entity : entityList) {
            dtoList.add(new ManageHallDto(
                    entity.getNumber_txt(),
                    entity.getCategory_txt(),
                    entity.getCount_txt()
            ));
        }
        return dtoList;

    }


    @Override
    public boolean update(ManageHallDto dto) throws SQLException, ClassNotFoundException {
        return hallDao.update(new Hall(dto.getNumber_txt(), dto.getCategory_txt(), dto.getCount_txt()));
    }


    @Override
    public boolean delete(ManageHallDto id) throws SQLException, ClassNotFoundException {
        return hallDao.delete(new Hall(id.getNumber_txt()));
    }
}



