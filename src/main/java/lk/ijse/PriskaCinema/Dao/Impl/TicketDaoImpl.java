package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.TicketDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;
import lk.ijse.PriskaCinema.entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TicketDaoImpl implements TicketDao {

    @Override
    public boolean save(Ticket dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?)",
                dto.getTicketnumber_txt(),dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),
                dto.getEmpid_txt(),dto.getTime_txt(),String.valueOf(dto.getDate_txt()));
    }

    @Override
    public ArrayList<Ticket> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Ticket> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<Ticket> itemList = new ArrayList<>();
        ResultSet resultSet = SqlUtil.test("SELECT * FROM ticket");

        while (resultSet.next()) {
            itemList.add(new Ticket(
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
    public boolean delete(Ticket id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM ticket WHERE t_num = ?",id.getTicketnumber_txt());
    }

    @Override
    public boolean update(Ticket dto) throws SQLException, ClassNotFoundException {
               return SqlUtil.test("update ticket set t_type = ?, movie_id = ?,screen = ?,price = ?,time = ?,date = ?, e_id = ? where t_num =?",
                       dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),dto.getTime_txt(),
                       String.valueOf(dto.getDate_txt()),dto.getEmpid_txt(),dto.getTicketnumber_txt());
    }



}
