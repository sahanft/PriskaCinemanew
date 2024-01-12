package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageParkingDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageParkingModel {
    public static boolean saveParking(ManageParkingDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO parking VALUES(?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getSpacemen_txt());
        ptm.setString(2, dto.getType_txt());
        ptm.setDouble(3, Double.parseDouble(String.valueOf(dto.getParkingfee_txt())));
        ptm.setDate(4, Date.valueOf(dto.getDate_txt()));


        return ptm.executeUpdate()>0;
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

    /*public static ArrayList<ManageParkingDto> getAllseat() throws SQLException {
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
    public static boolean deleteParking(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM parking WHERE space_no = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }

    public static boolean updateParking(ManageParkingDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update parking set space_type = ?, parking_fee = ?, date = ? where space_no =?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getType_txt());


        pstm.setDouble(2, dto.getParkingfee_txt());
        pstm.setDate(3, Date.valueOf(dto.getDate_txt()));

        pstm.setString(4, dto.getSpacemen_txt());







        return pstm.executeUpdate() > 0;
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
