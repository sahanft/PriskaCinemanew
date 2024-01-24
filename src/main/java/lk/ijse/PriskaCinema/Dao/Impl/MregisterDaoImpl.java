package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.MregisterDao;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MregisterDaoImpl implements MregisterDao {

    @Override
    public ArrayList<Admin> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Admin> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Admin admin) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();


        String sql = "INSERT INTO admin VALUES(?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, admin.getUserName());
        ptm.setString(2, admin.getPassword());

        return ptm.executeUpdate()>0;
    }

    @Override
    public boolean update(Admin admin) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Admin admin) throws SQLException, ClassNotFoundException {
        return false;
    }
}
