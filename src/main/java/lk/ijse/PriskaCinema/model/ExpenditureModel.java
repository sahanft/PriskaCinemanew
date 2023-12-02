package lk.ijse.PriskaCinema.model;

import javafx.scene.control.ChoiceDialog;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ExpenditureDto;
import lk.ijse.PriskaCinema.dto.IncomeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureModel {

    public static boolean saveExpenditure(ExpenditureDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO expenditure VALUES(?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getExpenditure_txt());
        ptm.setString(2, dto.getDescription2_txt());
        ptm.setString(3, dto.getMonth2_txt());
        ptm.setString(4, dto.getAmount2_txt());


        return ptm.executeUpdate()>0;
    }

    public static List<ExpenditureDto> loadAllexpenditure() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM expenditure";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ExpenditureDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ExpenditureDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)



            ));
        }
        return itemList;
    }

    public static ArrayList<ExpenditureDto> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM expenditure";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ExpenditureDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ExpenditureDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)



                    )
            );
        }
        return dtoList;

    }


    public static boolean deleteExpenditure(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM expenditure WHERE expenditure_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }


}
