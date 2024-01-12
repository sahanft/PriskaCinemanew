package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.ProducerDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProducerDaoImpl implements ProducerDao {
    @Override
    public ArrayList<ManageProducerDto> loadAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(ManageProducerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<ManageProducerDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(ManageProducerDto Dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO ProducerDetails VALUES(?,?)", producerDetailsDto.getPro_id(), producerDetailsDto.getMovie_id());
    }
}
