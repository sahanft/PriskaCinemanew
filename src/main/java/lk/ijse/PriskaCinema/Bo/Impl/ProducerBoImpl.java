package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.ProducerBo;
import lk.ijse.PriskaCinema.Dao.Custom.ProducerDao;
import lk.ijse.PriskaCinema.Dao.Impl.ProducerDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerBoImpl implements ProducerBo {

    ProducerDao producerDao = (ProducerDao) new ProducerDaoImpl();


    @Override
    public boolean save(ManageProducerDto dto) throws SQLException {
        return producerDao.save(dto);
    }

    @Override
    public List<ManageProducerDto> loadAll() throws SQLException {
        return producerDao.loadAll();
    }

    @Override
    public ArrayList<ManageProducerDto> getAll() throws SQLException {
        return producerDao.getAll();
    }

    @Override
    public boolean update(ManageProducerDto Dto) throws SQLException {
        return producerDao.update(Dto);
    }

    @Override
    public boolean delete(ManageProducerDto manageProducerDto) throws SQLException, ClassNotFoundException {
        return producerDao.delete(manageProducerDto);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return producerDao.delete(id);
    }
}
