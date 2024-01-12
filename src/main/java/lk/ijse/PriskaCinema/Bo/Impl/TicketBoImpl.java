package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.TicketBo;
import lk.ijse.PriskaCinema.Dao.Custom.TicketDao;
import lk.ijse.PriskaCinema.Dao.Impl.TicketDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBoImpl implements TicketBo {

    TicketDao ticketDao = (TicketDao) new TicketDaoImpl();


    @Override
    public boolean save(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
        return ticketDao.save(dto);
    }

    @Override
    public List<ManageTicketDto> loadAll() throws SQLException, ClassNotFoundException {
        return ticketDao.loadAll();
    }

    @Override
    public ArrayList<ManageTicketDto> getAll() throws SQLException, ClassNotFoundException {
        return ticketDao.getAll();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return ticketDao.delete(id);
    }

    @Override
    public boolean update(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
        return ticketDao.update(dto);
    }


}
