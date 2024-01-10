package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingBoImpl {

    public static boolean saveParking(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO parking VALUES(?,?,?,?)", dto.getSpacemen_txt(), dto.getType_txt(), dto.getParkingfee_txt(), dto.getDate_txt());
    }

    public static List<ManageParkingDto> loadAllparking() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM parking";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageParkingDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
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

   /* public static ArrayList<ManageParkingDto> getAllseat() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM parking";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageParkingDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ManageParkingDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getDate(4).toLocalDate()

                    )
            );
        }
        return dtoList;

    }
*/
    public static boolean deleteParking(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM parking WHERE space_no = ?", id);
    }

    public static boolean updateParking(ManageParkingDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("update parking set space_type = ?, parking_fee = ?, date = ? where space_no =?", dto.getSpacemen_txt(), dto.getType_txt(), dto.getParkingfee_txt(), dto.getDate_txt());
    }


   /* public static ManageParkingDto searchParking(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM parking WHERE space_no = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        ManageParkingDto dto = null;

        if(resultSet.next()) {
            String spacenum = resultSet.getString(1);
            String type = resultSet.getString(2);
            Double parkingfee = Double.valueOf(resultSet.getString(3));
            int date = resultSet.getInt(4);



            dto = new ManageParkingDto();
        }
        return dto;
    }

*/

}
