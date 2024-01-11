package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.EmployeeBo;
import lk.ijse.PriskaCinema.Dao.Custom.EmployeeDao;
import lk.ijse.PriskaCinema.Dao.Impl.EmployeeDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {

    EmployeeDao employeeDao =  new EmployeeDaoImpl();


    @Override
    public boolean save(ManageEmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(dto);
    }

    @Override
    public List<ManageEmployeeDto> loadAll() throws SQLException {
        return employeeDao.loadAll();
    }

    @Override
    public ArrayList<ManageEmployeeDto> getAll() throws SQLException {
        return employeeDao.getAll();
    }

   /* @Override
    public boolean Add(ManageEmployeeDto manageEmployeeDto) throws SQLException, ClassNotFoundException {
        return employeeDao.Add(manageEmployeeDto);
    }*/

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ManageEmployeeDto dto) throws SQLException {
        return employeeDao.update(dto);
    }

    @Override
    public boolean delete(ManageEmployeeDto manageEmployeeDto) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(manageEmployeeDto);
    }
}
