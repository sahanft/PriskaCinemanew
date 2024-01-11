package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.TicketDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {

    public boolean save(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?)", dto.getTicketnumber_txt(),dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),dto.getEmpid_txt(),dto.getTime_txt(),String.valueOf(dto.getDate_txt()));
    }

    @Override
    public ArrayList<ManageTicketDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<ManageTicketDto> loadAll() throws SQLException {
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

    @Override
    public ArrayList<ManageTicketDto> getAllseat() throws SQLException {
        return null;
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM ticket WHERE t_num = ?",id);
    }

    public boolean update(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
               return SqlUtil.test("update ticket set t_type = ?, movie_id = ?,screen = ?,price = ?,time = ?,date = ?, e_id = ? where t_num =?",dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),dto.getTime_txt(),String.valueOf(dto.getDate_txt()),dto.getEmpid_txt(),dto.getTicketnumber_txt());
    }

    @Override
    public boolean delete(ManageTicketDto manageTicketDto) throws SQLException, ClassNotFoundException {
        return false;
    }

}
