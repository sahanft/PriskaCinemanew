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
        return SqlUtil.test("INSERT INTO Seats VALUES(?,?,?)",dto.getSeatnumber_txt(),dto.getScreen_txt(),dto.getRownumber_txt());
    }

    @Override
    public ArrayList<Seat1Dto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<Seat1Dto> loadAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Seats";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<Seat1Dto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new Seat1Dto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }

        return itemList;
    }

    @Override
    public ArrayList<Seat1Dto> getAllseat() throws SQLException {
        return null;
    }

    /*  public static ArrayList<Seat1Dto> getAllseat() throws SQLException {
          Connection connection = DbConnection.getInstance().getConnection();

          String sql = "SELECT * FROM Seats";

          PreparedStatement pstm = connection.prepareStatement(sql);
          ResultSet resultSet = pstm.executeQuery();

          ArrayList<Seat1Dto> dtoList = new ArrayList<>();

          while(resultSet.next()) {
              dtoList.add(
                      new Seat1Dto(
                              resultSet.getString(1),
                              resultSet.getString(2),
                              resultSet.getString(3)

                      )
              );
          }
          return dtoList;

      }
  */
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Seats WHERE seat_num = ?", id);
    }


    public boolean update(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("update Seats set screen = ?, row_num = ? where seat_num =?", dto.getScreen_txt(), dto.getRownumber_txt(), dto.getSeatnumber_txt());
    }

    @Override
    public boolean delete(Seat1Dto seat1Dto) throws SQLException, ClassNotFoundException {
        return false;
    }

}
