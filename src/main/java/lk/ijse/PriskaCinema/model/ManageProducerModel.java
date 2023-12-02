package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.Seat1Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageProducerModel {
    public static boolean saveProducer(ManageProducerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Producers VALUES(?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getProducerid_txt());
        ptm.setString(2, dto.getName_txt());
        ptm.setString(3, dto.getAddress_txt());
        ptm.setString(4, dto.getMobilenumber_txt());


        return ptm.executeUpdate()>0;
    }

    public static List<ManageProducerDto> loadAllproducer() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Producers";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageProducerDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ManageProducerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }

        return itemList;
    }

    public static ArrayList<ManageProducerDto> getAllproducer() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Seats";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageProducerDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ManageProducerDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)

                    )
            );
        }
        return dtoList;

    }

    public static boolean updateProducer(ManageProducerDto Dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Producers SET name = ?, pro_address = ?, pro_tele = ? WHERE pro_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, Dto.getName_txt());
        pstm.setString(2, Dto.getAddress_txt());
        pstm.setString(3, Dto.getMobilenumber_txt());
        pstm.setString(4, Dto.getProducerid_txt());

        return pstm.executeUpdate() > 0;
    }



    public static boolean deleteProducer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Producers WHERE pro_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }




}
