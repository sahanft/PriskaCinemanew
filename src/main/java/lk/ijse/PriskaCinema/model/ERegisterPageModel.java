package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.EmployeeRegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ERegisterPageModel {
    public static boolean registerAdmin(EmployeeRegisterDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();


        String sql = "INSERT INTO user VALUES(?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getUsername());
        ptm.setString(2, dto.getPassword());

        return ptm.executeUpdate()>0;

    }

}
