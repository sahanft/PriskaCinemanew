package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.AttendansDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AttendansModel {

    public static boolean addAttendance(AttendansDto dto) throws SQLException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Attendance (Date, Id, Name) VALUES (?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm .setString(1, dto.getDate());
            pstm.setString(2, dto.getId());
            pstm.setString(3, dto.getName());

            return pstm.executeUpdate() > 0;
        }
    }

    public static boolean addAttendansList(List<AttendansDto> attendansDtoList) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Attendance (date,e_id, name) VALUES (?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);

            for (AttendansDto dto : attendansDtoList) {
                pstm.setString(1, dto.getDate());
                pstm.setString(2, dto.getId());
                pstm.setString(3, dto.getName());

                pstm.addBatch();
            }

            int[] result = pstm.executeBatch();
            connection.commit();


            for (int i : result) {
                if (i <= 0) {
                    return false;
                }
            }

            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}

