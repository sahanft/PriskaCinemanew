package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Seat1Model {

    public static boolean saveSeat(Seat1Dto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Seats VALUES(?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getSeatnumber_txt());
        ptm.setString(2, dto.getScreen_txt());
        ptm.setString(3, dto.getRownumber_txt());

        return ptm.executeUpdate()>0;
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

    public static ArrayList<Seat1Dto> getAllseat() throws SQLException {
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

    public static boolean deleteSeat(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Seats WHERE seat_num = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }


    public static boolean updateSeat(Seat1Dto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update Seats set screen = ?, row_num = ? where seat_num =?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getScreen_txt());
        pstm.setString(2, dto.getRownumber_txt());
        pstm.setString(3, dto.getSeatnumber_txt());

        return pstm.executeUpdate() > 0;
    }


    public static Seat1Dto searchSeat(String id) throws SQLException {
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






}


