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

    public static ArrayList<ManageEmployeeDto> getAll() throws SQLException {
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



   /* public static boolean updateEmployee(ManageEmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();




        String sql = "UPDATE Employee SET empid = ?, empname = ?, jobtype = ?,mobile = ?,nic = ?,salary = ?, WHERE address= ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEmpid_txt());
        pstm.setString(2, dto.getEmpname_txt());
        pstm.setString(3, dto.getEmpjobtype_txt());
        pstm.setString(4, String.valueOf(dto.getEmpmobile_txt()));
        pstm.setString(5, dto.getEmpnic_txt());
        pstm.setDouble(6, Double.valueOf(dto.getEmpsalary_txt()));
        pstm.setString(7, dto.getEmpaddress_txt());
        int rowsUpdated = pstm.executeUpdate();

        // Check if the update was successful
        if (rowsUpdated > 0) {
            System.out.println("Employee updated successfully.");
            return true;
        } else {
            System.out.println("Failed to update employee.");
            return false;
        }
    }
*/
   public static boolean updateEmployee(ManageEmployeeDto dto) throws SQLException {
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




    public static List<ManageEmployeeDto> getAllEmployee() throws SQLException {
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
    }

    public static ManageEmployeeDto searchEmployee(String id) throws SQLException {
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


}
