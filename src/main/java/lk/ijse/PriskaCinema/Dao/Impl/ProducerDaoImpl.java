package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerDaoImpl {

    public static boolean save(ManageProducerDto dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("INSERT INTO Producers VALUES(?,?,?,?)", dto.getProducerid_txt(), dto.getName_txt(), dto.getAddress_txt(), dto.getMobilenumber_txt());
    }

   /* public static List<ManageProducerDto> loadAllproducer() throws SQLException {
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
    }*/

    public static ArrayList<ManageProducerDto> getAll() throws SQLException {
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

    public static boolean update(ManageProducerDto Dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("UPDATE Producers SET name = ?, pro_address = ?, pro_tele = ? WHERE pro_id = ?", Dto.getName_txt(), Dto.getAddress_txt(), Dto.getMobilenumber_txt(), Dto.getProducerid_txt());
    }



    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test( "DELETE FROM Producers WHERE pro_id = ?", id);
    }





}
