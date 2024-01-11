package lk.ijse.PriskaCinema.Dao;

import lk.ijse.PriskaCinema.Dao.SupperDAO;
import lk.ijse.PriskaCinema.dto.ManageEmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SupperDAO {

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    List<T> loadAll() throws SQLException;

    boolean save(T t) throws SQLException, ClassNotFoundException;

    boolean update(T t) throws SQLException, ClassNotFoundException;

    boolean delete(T t) throws SQLException, ClassNotFoundException;
}
