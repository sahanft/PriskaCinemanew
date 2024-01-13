package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.EmployeeDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.employeeDto;
import lk.ijse.PriskaCinema.entity.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public boolean save(employee entity) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO employee VALUES(?,?,?,?,?,?,?)", entity.getEmpid_txt(), entity.getEmpname_txt(), entity.getEmpjobtype_txt(), entity.getEmpmobile_txt(),
                entity.getEmpnic_txt(), entity.getEmpsalary_txt(), entity.getEmpaddress_txt());
    }


    public ArrayList<employee>  loadAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM employee");

        ArrayList<employee> itemList = new ArrayList<>();

        while (resultSet.next()) {
            itemList.add(new employee(
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
    public ArrayList<employee> getAll() throws SQLException {
        return null;
    }


    @Override
    public boolean delete(employee id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM employee WHERE e_id = ?", id);
    }


    @Override
    public boolean update(employee dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("update employee set name = ?, type = ?, e_tele = ?,nic = ?,salary = ?,address = ? where e_id = ?",
                dto.getEmpname_txt(),dto.getEmpjobtype_txt(),dto.getEmpmobile_txt(),dto.getEmpnic_txt(),dto.getEmpsalary_txt(),
                dto.getEmpaddress_txt(),dto.getEmpid_txt());

    }


}
