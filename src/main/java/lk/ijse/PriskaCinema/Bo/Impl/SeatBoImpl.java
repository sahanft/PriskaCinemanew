package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.SeatBo;
import lk.ijse.PriskaCinema.Dao.Custom.SeatDao;
import lk.ijse.PriskaCinema.Dao.Impl.SeatDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.Seat1Dto;
import lk.ijse.PriskaCinema.entity.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatBoImpl implements SeatBo {

  SeatDao seatDao = new SeatDaoImpl();

    @Override
    public boolean save(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return seatDao.save(new Seat(dto.getSeatnumber_txt(),dto.getScreen_txt(),dto.getRownumber_txt()));
    }


    @Override
    public List<Seat1Dto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Seat> entityList = seatDao.loadAll();
        ArrayList<Seat1Dto> dtoList = new ArrayList<>();
        for (Seat entity : entityList) {
            dtoList.add(new Seat1Dto(
                    entity.getSeatnumber_txt(),
                    entity.getScreen_txt(),
                    entity.getRownumber_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public ArrayList<Seat1Dto> getAll() throws SQLException {
        ArrayList<Seat> entityList = seatDao.getAll();
        ArrayList<Seat1Dto> dtoList = new ArrayList<>();
        for (Seat entity : entityList) {
            dtoList.add(new Seat1Dto(
                    entity.getSeatnumber_txt(),
                    entity.getScreen_txt(),
                    entity.getRownumber_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean delete(Seat1Dto id) throws SQLException, ClassNotFoundException {
        return seatDao.delete(new Seat(id.getSeatnumber_txt()));
    }

    @Override
    public boolean update(Seat1Dto dto) throws SQLException, ClassNotFoundException {
        return seatDao.update(new Seat(dto.getSeatnumber_txt(),dto.getScreen_txt(),dto.getRownumber_txt()));
    }


}
