package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.EmployeeDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public boolean save(ManageEmployeeDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO employee VALUES(?,?,?,?,?,?,?)", dto.getEmpid_txt(), dto.getEmpname_txt(), dto.getEmpjobtype_txt(), dto.getEmpmobile_txt(),
                dto.getEmpnic_txt(), dto.getEmpsalary_txt(), dto.getEmpaddress_txt());
    }

    public List<ManageEmployeeDto> loadAll() throws SQLException {
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

    @Override
    public ArrayList<ManageEmployeeDto> getAll() throws SQLException {
        return null;
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

    public boolean delete(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }


    public boolean update(ManageEmployeeDto dto) throws SQLException {
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

    @Override
    public List<ManageEmployeeDto> getAllEmployee() throws SQLException {
        return null;
    }

    @Override
    public ManageEmployeeDto searchEmployee(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(ManageEmployeeDto manageEmployeeDto) throws SQLException, ClassNotFoundException {
        return false;
    }

}
