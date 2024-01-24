package lk.ijse.PriskaCinema.Dao.Custom;

import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.employeeDto;
import lk.ijse.PriskaCinema.entity.employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public interface EmployeeDao extends CrudDAO<employee> {

    boolean save(employee dto) throws SQLException, ClassNotFoundException;

    ArrayList<employee> loadAll() throws SQLException, ClassNotFoundException;

    ArrayList<employee> getAll() throws SQLException;

    boolean delete(employee id) throws SQLException, ClassNotFoundException;

    boolean update(employee dto) throws SQLException, ClassNotFoundException;


}
