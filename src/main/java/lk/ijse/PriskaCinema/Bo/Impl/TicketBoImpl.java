package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.TicketBo;
import lk.ijse.PriskaCinema.Dao.Custom.TicketDao;
import lk.ijse.PriskaCinema.Dao.Impl.TicketDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageTicketDto;
import lk.ijse.PriskaCinema.entity.Ticket;

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
        return ticketDao.save(new Ticket(dto.getTicketnumber_txt(),dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),
                dto.getEmpid_txt(),dto.getTime_txt(),dto.getDate_txt()));
    }

    @Override
    public List<ManageTicketDto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Ticket> entityList = ticketDao.loadAll();
        ArrayList<ManageTicketDto> dtoList = new ArrayList<>();
        for (Ticket entity : entityList) {
            dtoList.add(new ManageTicketDto(
                    entity.getTicketnumber_txt(),
                    entity.getTickettype_txt(),
                    entity.getMovieid_txt(),
                    entity.getScreen_txt(),
                    entity.getPrice_txt(),
                    entity.getEmpid_txt(),
                    entity.getTime_txt(),
                    entity.getDate_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public ArrayList<ManageTicketDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Ticket> entityList = ticketDao.getAll();
        ArrayList<ManageTicketDto> dtoList = new ArrayList<>();
        for (Ticket entity : entityList) {
            dtoList.add(new ManageTicketDto(
                    entity.getTicketnumber_txt(),
                    entity.getTickettype_txt(),
                    entity.getMovieid_txt(),
                    entity.getScreen_txt(),
                    entity.getPrice_txt(),
                    entity.getEmpid_txt(),
                    entity.getTime_txt(),
                    entity.getDate_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean delete(ManageTicketDto id) throws SQLException, ClassNotFoundException {
        return ticketDao.delete(new Ticket(id.getTicketnumber_txt()));
    }

    @Override
    public boolean update(ManageTicketDto dto) throws SQLException, ClassNotFoundException {
        return ticketDao.update(new Ticket(dto.getTicketnumber_txt(),dto.getTickettype_txt(),dto.getMovieid_txt(),dto.getScreen_txt(),dto.getPrice_txt(),
                dto.getEmpid_txt(),dto.getTime_txt(),dto.getDate_txt()));
    }


}
