package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBoImpl {

    public static boolean saveTicket(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?)", dto.getTicketnumber_txt(),dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),dto.getEmpid_txt(),dto.getTime_txt(),String.valueOf(dto.getDate_txt()));
    }

    public static List<ManageTicketDto> loadAllparking() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM ticket";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageTicketDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ManageTicketDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDate(8).toLocalDate()

            ));
        }
        return itemList;
    }

   /* public static ArrayList<ManageTicketDto> getAllseat() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM ticket";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ManageTicketDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ManageTicketDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getDate(8).toLocalDate()

                    )
            );
        }
        return dtoList;





    }*/

    public static boolean deleteTicket(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM ticket WHERE t_num = ?",id);
    }

    public static boolean updateTicket(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
               return SqlUtil.test("update ticket set t_type = ?, movie_id = ?,screen = ?,price = ?,time = ?,date = ?, e_id = ? where t_num =?",dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),dto.getTime_txt(),String.valueOf(dto.getDate_txt()),dto.getEmpid_txt(),dto.getTicketnumber_txt());
    }


  /*  public static ManageTicketDto searchTicket(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM ticket WHERE t_num = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        ManageTicketDto dto = null;

        if(resultSet.next()) {
            String tnumber = resultSet.getString(1);
            String empid = resultSet.getString(2);
            String type = resultSet.getString(3);
            String movieid = resultSet.getString(4);
            String screen = resultSet.getString(5);
            Double price = Double.valueOf(resultSet.getString(6));
            String time = resultSet.getString(7);
            int date = resultSet.getInt(8);





            dto = new ManageTicketDto();
        }
        return dto;
    }
*/





}
