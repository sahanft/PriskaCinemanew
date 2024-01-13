package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.MovieBo;
import lk.ijse.PriskaCinema.Dao.Custom.MovieDao;
import lk.ijse.PriskaCinema.Dao.Custom.ProducerDao;
import lk.ijse.PriskaCinema.Dao.Impl.MovieDaoImpl;
import lk.ijse.PriskaCinema.Dao.Impl.ProducerDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;
import lk.ijse.PriskaCinema.entity.ProducerDetails;
import lk.ijse.PriskaCinema.entity.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieBoImpl implements MovieBo {

    MovieDao movieDao = new MovieDaoImpl();
    ProducerDao producerDao = new ProducerDaoImpl();


    @Override
    public boolean save(ManageMoviesDto dto) throws SQLException, ClassNotFoundException {
        return movieDao.save(new movie(dto.getId_txt(), dto.getName_txt(), dto.getGenre_txt(), dto.getDuration_txt(), dto.getTime_txt()));
    }

    @Override
    public List<ManageMoviesDto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<movie> entityList = movieDao.loadAll();
        ArrayList<ManageMoviesDto> dtoList = new ArrayList<>();
        for (movie entity : entityList) {
            dtoList.add(new ManageMoviesDto(
                    entity.getId_txt(),
                    entity.getName_txt(),
                    entity.getGenre_txt(),
                    entity.getDuration_txt(),
                    entity.getTime_txt()
            ));
        }
        return dtoList;

    }

    @Override
    public ArrayList<ManageMoviesDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<movie> entityList = movieDao.getAll();
        ArrayList<ManageMoviesDto> dtoList = new ArrayList<>();
        for (movie entity : entityList) {
            dtoList.add(new ManageMoviesDto(
                    entity.getId_txt(),
                    entity.getName_txt(),
                    entity.getGenre_txt(),
                    entity.getDuration_txt(),
                    entity.getTime_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean update(ManageMoviesDto Dto) throws SQLException, ClassNotFoundException {
        return movieDao.update(new movie(Dto.getId_txt(), Dto.getName_txt(), Dto.getGenre_txt(), Dto.getDuration_txt(), Dto.getTime_txt()));
    }


    @Override
    public boolean delete(ManageMoviesDto id) throws SQLException, ClassNotFoundException {
        return movieDao.delete((new movie(id.getId_txt())));
    }

    @Override
    public boolean saveProducerMovieDetails(ProducerDetailsDto dto) throws SQLException, ClassNotFoundException {
        return producerDao.saveProducerMovieDetails(new ProducerDetails(dto.getPro_id(), dto.getMovie_id()));
    }

    @Override
    public boolean saveMovie(ManageMoviesDto dto) throws SQLException, ClassNotFoundException {
        return movieDao.save(new movie(dto.getId_txt(), dto.getName_txt(), dto.getGenre_txt(), dto.getDuration_txt(), dto.getTime_txt()));
    }
}
