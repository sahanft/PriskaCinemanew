package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageHallDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallBoImpl {

    public static boolean saveHall(ManageHallDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO Film_hall VALUES(?,?,?)", dto.getNumber_txt(), dto.getCategory_txt(), dto.getCount_txt());
    }

    public static List<ManageHallDto> loadAllhall() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Film_hall";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageHallDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ManageHallDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            ));
        }

        return itemList;
    }

   /* public static ArrayList<ManageHallDto> getAllhall() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Film_hall";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageHallDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ManageHallDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)


                    )
            );
        }
        return dtoList;

    }
*/
    public static boolean updateHall(ManageHallDto Dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE Movies SET category = ?, seat_count = ? where hall_no = ?", Dto.getCategory_txt(), Dto.getCount_txt(), Dto.getNumber_txt());
    }



    public static boolean deleteHall(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Film_hall WHERE hall_no = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);


        return SqlUtil.test("DELETE FROM Film_hall WHERE hall_no = ?", id);
    }







}



