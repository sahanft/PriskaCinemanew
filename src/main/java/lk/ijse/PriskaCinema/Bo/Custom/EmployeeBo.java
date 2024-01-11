package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBo extends CrudDAO<ManageEmployeeDto> {

    boolean save(ManageEmployeeDto dto) throws SQLException, ClassNotFoundException;

    List<ManageEmployeeDto> loadAll() throws SQLException;

    ArrayList<ManageEmployeeDto> getAll() throws SQLException;

    boolean delete(String id) throws SQLException;

    boolean update(ManageEmployeeDto dto) throws SQLException;



}
