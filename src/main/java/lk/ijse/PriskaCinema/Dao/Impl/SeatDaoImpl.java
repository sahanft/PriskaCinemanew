package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.SeatDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDaoImpl implements SeatDao {

    public boolean save(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO Seats VALUES(?,?,?)",
                dto.getSeatnumber_txt(),dto.getScreen_txt(),dto.getRownumber_txt());
    }

    @Override
    public ArrayList<Seat1Dto> getAll() throws SQLException {
        return null;
    }

    public ArrayList<Seat1Dto> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<Seat1Dto> itemList = new ArrayList<>();
        ResultSet resultSet = SqlUtil.test("SELECT * FROM Seats");

        while (resultSet.next()) {
            itemList.add(new Seat1Dto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }

        return itemList;
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Seats WHERE seat_num = ?", id);
    }


    public boolean update(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("update Seats set screen = ?, row_num = ? where seat_num =?",
                dto.getScreen_txt(), dto.getRownumber_txt(), dto.getSeatnumber_txt());
    }

}
