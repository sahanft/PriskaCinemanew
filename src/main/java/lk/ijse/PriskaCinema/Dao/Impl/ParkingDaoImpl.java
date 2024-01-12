package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.ParkingBo;
import lk.ijse.PriskaCinema.Dao.Custom.ParkingDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDaoImpl implements ParkingDao {

    public boolean save(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO parking VALUES(?,?,?,?)",
                dto.getSpacemen_txt(), dto.getType_txt(), dto.getParkingfee_txt(), dto.getDate_txt());
    }

    public ArrayList<ManageParkingDto> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<ManageParkingDto> itemList = new ArrayList<>();
        ResultSet resultSet = SqlUtil.test("SELECT * FROM parking");

        while (resultSet.next()) {
            itemList.add(new ManageParkingDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDate(4).toLocalDate()

            ));

        }
        return itemList;
    }

    @Override
    public ArrayList<ManageParkingDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM parking WHERE space_no = ?", id);
    }

    public boolean update(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("update parking set space_type = ?, parking_fee = ?, date = ? where space_no =?",
                dto.getSpacemen_txt(), dto.getType_txt(), dto.getParkingfee_txt(), dto.getDate_txt());
    }



}
