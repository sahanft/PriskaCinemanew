package lk.ijse.PriskaCinema.model;

import javafx.scene.control.Alert;
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
        ptm.setString(3, dto.getParkingfee_txt());
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
                    resultSet.getString(3),
                    resultSet.getDate(4).toLocalDate()

            ));
        }
        return itemList;
    }

    public static ArrayList<ManageParkingDto> getAllseat() throws SQLException {
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
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate()

                    )
            );
        }
        return dtoList;

    }



}
