package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MRegisterPageModel {
    public static boolean registerAdmin(LoginDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();


        String sql = "INSERT INTO admin VALUES(?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getUserName());
        ptm.setString(2, dto.getPassword());

        return ptm.executeUpdate()>0;

    }

}
