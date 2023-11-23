package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageEmployeeModel {
    public static boolean saveEmployee(ManageEmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getEmpid_txt());
        ptm.setString(2, dto.getEmpname_txt());
        ptm.setString(3, dto.getEmpjobtype_txt());
        ptm.setInt(4, dto.getEmpmobile_txt());
        ptm.setString(5, dto.getEmpnic_txt());
        ptm.setDouble(6, dto.getEmpsalary_txt());
        ptm.setString(7, dto.getEmpaddress_txt());

        return ptm.executeUpdate()>0;
    }

    public static List<ManageEmployeeDto> loadAllemployee() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageEmployeeDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ManageEmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getString(7)


            ));
        }
        return itemList;
    }

    public static ArrayList<ManageEmployeeDto> getAllseat() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageEmployeeDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ManageEmployeeDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getDouble(6),
                            resultSet.getString(7)


                    )
            );
        }
        return dtoList;

    }


    public static boolean deleteEmployee(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }



    public static boolean updateEmployee(ManageEmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE employee SET name = ? , address = ? ,tele = ? WHERE id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEmpid_txt());
        pstm.setString(2, dto.getEmpname_txt());

        pstm.setString(4, String.valueOf(dto.getEmpsalary_txt()));

        return pstm.executeUpdate()>0;
    }

    public List<ManageEmployeeDto> getAllEmployee() {
        return null;
    }
}
