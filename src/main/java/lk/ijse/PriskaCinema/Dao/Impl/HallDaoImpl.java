package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.HallDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallDaoImpl implements HallDao {

    public boolean save(ManageHallDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO Film_hall VALUES(?,?,?)", dto.getNumber_txt(), dto.getCategory_txt(), dto.getCount_txt());
    }

    @Override
    public ArrayList<ManageHallDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<ManageHallDto> loadAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM Film_hall");
        ArrayList<ManageHallDto> itemList = new ArrayList<>();

        while (resultSet.next()) {
            itemList.add(new ManageHallDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            ));
        }

        return itemList;
    }




    public boolean update(ManageHallDto Dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE Movies SET category = ?, seat_count = ? where hall_no = ?",
                Dto.getCategory_txt(), Dto.getCount_txt(), Dto.getNumber_txt());
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Film_hall WHERE hall_no = ?", id);
    }

}



