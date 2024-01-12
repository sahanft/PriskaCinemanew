package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.dto.employeeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBo extends SuperBo {

    boolean save(employeeDto dto) throws SQLException, ClassNotFoundException;

    List<employeeDto> loadAll() throws SQLException, ClassNotFoundException;

    ArrayList<employeeDto> getAll() throws SQLException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(employeeDto dto) throws SQLException, ClassNotFoundException;


}
