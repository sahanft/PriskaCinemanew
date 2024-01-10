package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl {

    public static boolean save(ManageEmployeeDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO employee VALUES(?,?,?,?,?,?,?)", dto.getEmpid_txt(), dto.getEmpname_txt(), dto.getEmpjobtype_txt(), dto.getEmpmobile_txt(),
                dto.getEmpnic_txt(), dto.getEmpsalary_txt(), dto.getEmpaddress_txt());
    }

    public static List<ManageEmployeeDto> loadAll() throws SQLException {
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

   /* public static ArrayList<ManageEmployeeDto> getAll() throws SQLException {
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
*/

    public static boolean delete(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }


    public static boolean update(ManageEmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update employee set name = ?, type = ?, e_tele = ?,nic = ?,salary = ?,address = ? where e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getEmpname_txt());
        pstm.setString(2, dto.getEmpjobtype_txt());
        pstm.setString(3, String.valueOf(dto.getEmpmobile_txt()));
        pstm.setString(4, dto.getEmpnic_txt());
        pstm.setDouble(5, dto.getEmpsalary_txt());
        pstm.setString(6, dto.getEmpaddress_txt());
        pstm.setString(7, dto.getEmpid_txt());





        return pstm.executeUpdate() > 0;
    }




  /*  public static List<ManageEmployeeDto> getAllEmployee() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageEmployeeDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(new ManageEmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getString(7)
            ));
        }
        return dtoList;
    }*/

   /* public static ManageEmployeeDto searchEmployee(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        ManageEmployeeDto dto = null;

        if(resultSet.next()) {
            String Id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String type = resultSet.getString(3);
            int tele = resultSet.getInt(4);
            String nic = resultSet.getString(5);
            double salary = resultSet.getDouble(6);
            String address = resultSet.getString(7);

            dto = new ManageEmployeeDto(Id, name, type, tele, nic, salary, address);
        }
        return dto;
    }
*/
}
