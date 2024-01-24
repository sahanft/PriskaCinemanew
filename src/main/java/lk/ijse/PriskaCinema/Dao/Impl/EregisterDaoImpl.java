package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.EregisterDao;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.entity.User;
import lombok.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;




public class EregisterDaoImpl implements EregisterDao {
    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<User> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();


        String sql = "INSERT INTO user VALUES(?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, user.getUsername());
        ptm.setString(2, user.getPassword());

        return ptm.executeUpdate()>0;
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(User user) throws SQLException, ClassNotFoundException {
        return false;
    }
}
