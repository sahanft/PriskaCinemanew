package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.ParkingBo;
import lk.ijse.PriskaCinema.Dao.Custom.ParkingDao;
import lk.ijse.PriskaCinema.Dao.Impl.ParkingDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;
import lk.ijse.PriskaCinema.entity.Parking;

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
        return parkingDao.save(new Parking(dto.getSpacemen_txt(), dto.getType_txt(), dto.getParkingfee_txt(), dto.getDate_txt()));
    }

    @Override
    public List<ManageParkingDto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Parking> entityList = parkingDao.loadAll();
        ArrayList<ManageParkingDto> dtoList = new ArrayList<>();
        for (Parking entity : entityList) {
            dtoList.add(new ManageParkingDto(
                    entity.getSpacemen_txt(),
                    entity.getType_txt(),
                    entity.getParkingfee_txt(),
                    entity.getDate_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public ArrayList<ManageParkingDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Parking> entityList = parkingDao.getAll();
        ArrayList<ManageParkingDto> dtoList = new ArrayList<>();
        for (Parking entity : entityList) {
            dtoList.add(new ManageParkingDto(
                    entity.getSpacemen_txt(),
                    entity.getType_txt(),
                    entity.getParkingfee_txt(),
                    entity.getDate_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return parkingDao.delete(String.valueOf(new Parking(id)));
    }

    @Override
    public boolean update(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return parkingDao.update(new Parking(dto.getSpacemen_txt(), dto.getType_txt(), dto.getParkingfee_txt(), dto.getDate_txt()));
    }

}
