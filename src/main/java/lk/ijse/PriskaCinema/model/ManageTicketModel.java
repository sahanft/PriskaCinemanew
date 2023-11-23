package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageTicketModel {


    public static boolean saveTicket(ManageTicketDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getTicketnumber_txt());
        ptm.setString(2, dto.getTickettype_txt());
        ptm.setString(3, dto.getMovieid_txt());
        ptm.setString(4, dto.getScreen_txt());
        ptm.setString(5, dto.getPrice_txt());
        ptm.setString(6, dto.getEmpid_txt());
        ptm.setString(7, dto.getTime_txt());
        ptm.setString(8, String.valueOf(dto.getDate_txt()));







        return ptm.executeUpdate()>0;
    }

    public static List<ManageTicketDto> loadAllparking() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM ticket";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageTicketDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ManageTicketDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDate(8).toLocalDate()

            ));
        }
        return itemList;
    }

    public static ArrayList<ManageTicketDto> getAllseat() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM ticket";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageTicketDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ManageTicketDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getDate(8).toLocalDate()

                    )
            );
        }
        return dtoList;





    }
}
