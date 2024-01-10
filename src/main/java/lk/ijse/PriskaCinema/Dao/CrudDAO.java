package lk.ijse.PriskaCinema.Dao;

import lk.ijse.PriskaCinema.Dao.SupperDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SupperDAO {

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean Add(T t) throws SQLException, ClassNotFoundException;

    boolean update(T t) throws SQLException, ClassNotFoundException;

    boolean delete(T t) throws SQLException, ClassNotFoundException;
}
