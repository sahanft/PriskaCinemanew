package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageHallDto;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageHallModel {

    public static boolean saveHall(ManageHallDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Film_hall VALUES(?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getNumber_txt());
        ptm.setString(2, dto.getCategory_txt());
        ptm.setString(3, dto.getCount_txt());



        return ptm.executeUpdate()>0;
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

    public static ArrayList<ManageHallDto> getAllhall() throws SQLException {
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

    public static boolean updateHall(ManageHallDto Dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Movies SET category = ?, seat_count = ? where hall_no = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, Dto.getCategory_txt());
        pstm.setString(2, Dto.getCount_txt());
        pstm.setString(3, Dto.getNumber_txt());


        return pstm.executeUpdate() > 0;
    }



    public static boolean deleteHall(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Film_hall WHERE hall_no = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);


        return pstm.executeUpdate() > 0;
    }






}
