package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.IncomeDto;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeModel {


    public static boolean saveIncome(IncomeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO income VALUES(?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getIncome_txt());
        ptm.setString(2, dto.getDescription_txt());
        ptm.setString(3, dto.getMonth_txt());
        ptm.setDouble(4, dto.getAmount_txt());


        return ptm.executeUpdate()>0;
    }

    public static List<IncomeDto> loadAllincome() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM income";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<IncomeDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new IncomeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)



            ));
        }
        return itemList;
    }

    public static ArrayList<IncomeDto> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM income";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<IncomeDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new IncomeDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)



                    )
            );
        }
        return dtoList;

    }


    public static boolean deleteIncome(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM income WHERE income_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }



}
