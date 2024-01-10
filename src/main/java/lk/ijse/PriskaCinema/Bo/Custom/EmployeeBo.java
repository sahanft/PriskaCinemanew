package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBo extends CrudDAO<ManageEmployeeDto> {

    boolean saveEmployee(ManageEmployeeDto dto) throws SQLException;

    List<ManageEmployeeDto> loadAllemployee() throws SQLException;

    ArrayList<ManageEmployeeDto> getAll() throws SQLException;

    boolean deleteEmployee(String id) throws SQLException;

    boolean updateEmployee(ManageEmployeeDto dto) throws SQLException;

    List<ManageEmployeeDto> getAllEmployee() throws SQLException;

    ManageEmployeeDto searchEmployee(String id) throws SQLException;

}
