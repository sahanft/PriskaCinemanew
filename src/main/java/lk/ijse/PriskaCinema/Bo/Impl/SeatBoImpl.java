package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatBoImpl {

    public static boolean saveSeat(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO Seats VALUES(?,?,?)",dto.getSeatnumber_txt(),dto.getScreen_txt(),dto.getRownumber_txt());
    }

    public static List<Seat1Dto> loadAllseat() throws SQLException {
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
    public static boolean deleteSeat(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Seats WHERE seat_num = ?", id);
    }


    public static boolean updateSeat(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("update Seats set screen = ?, row_num = ? where seat_num =?", dto.getScreen_txt(), dto.getRownumber_txt(), dto.getSeatnumber_txt());
    }


  /*  public static Seat1Dto searchSeat(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Seats WHERE seat_num = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        Seat1Dto dto = null;

        if(resultSet.next()) {
            String screens = resultSet.getString(1);
            String rownumber = resultSet.getString(2);
            String seatnumbers = resultSet.getString(3);

            dto = new Seat1Dto();
        }
        return dto;
    }

*/





}
