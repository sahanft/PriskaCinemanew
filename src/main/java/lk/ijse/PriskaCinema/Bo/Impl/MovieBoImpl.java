package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.MovieBo;
import lk.ijse.PriskaCinema.Dao.Custom.MovieDao;
import lk.ijse.PriskaCinema.Dao.Impl.MovieDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieBoImpl implements MovieBo {

    MovieDao movieDao = (MovieDao) new MovieDaoImpl();


    @Override
    public boolean save(ManageMoviesDto dto) throws SQLException, ClassNotFoundException {
        return movieDao.save(dto);
    }

    @Override
    public List<ManageMoviesDto> loadAll() throws SQLException {
        return movieDao.loadAll();
    }

    @Override
    public ArrayList<ManageMoviesDto> getAll() throws SQLException, ClassNotFoundException {
        return movieDao.getAll();
    }

    @Override
    public boolean update(ManageMoviesDto Dto) throws SQLException, ClassNotFoundException {
        return movieDao.update(Dto);
    }

    @Override
    public boolean delete(ManageMoviesDto manageMoviesDto) throws SQLException, ClassNotFoundException {
        return movieDao.delete(manageMoviesDto);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return movieDao.delete(id);
    }

    @Override
    public boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException {
        return movieDao.saveProducerMovieDetails(producerDetailsDto);
    }
}
