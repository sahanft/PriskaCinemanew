package lk.ijse.PriskaCinema.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SupperDAO {

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    ArrayList<T> loadAll() throws SQLException, ClassNotFoundException;

    boolean save(T t) throws SQLException, ClassNotFoundException;

    boolean update(T t) throws SQLException, ClassNotFoundException;

    boolean delete(T t) throws SQLException, ClassNotFoundException;
}
