package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.ProducerBo;
import lk.ijse.PriskaCinema.Dao.Custom.ProducerDao;
import lk.ijse.PriskaCinema.Dao.Impl.ProducerDaoImpl;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.entity.Producer;
import lk.ijse.PriskaCinema.entity.ProducerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerBoImpl implements ProducerBo {

    ProducerDao producerDao = (ProducerDao) new ProducerDaoImpl();


    @Override
    public boolean save(ManageProducerDto dto) throws SQLException, ClassNotFoundException {
        return producerDao.save(new Producer(dto.getProducerid_txt(), dto.getName_txt(), dto.getAddress_txt(), dto.getMobilenumber_txt()));
    }

    @Override
    public List<ManageProducerDto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Producer> entityList = producerDao.loadAll();
        ArrayList<ManageProducerDto> dtoList = new ArrayList<>();
        for (Producer entity : entityList) {
            dtoList.add(new ManageProducerDto(
                    entity.getProducerid_txt(),
                    entity.getName_txt(),
                    entity.getAddress_txt(),
                    entity.getMobilenumber_txt()
            ));
        }
    }

    @Override
    public ArrayList<ManageProducerDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Producer> entityList = producerDao.getAll();
        ArrayList<ManageProducerDto> dtoList = new ArrayList<>();
        for (Producer entity : entityList) {
            dtoList.add(new ManageProducerDto(
                    entity.getProducerid_txt(),
                    entity.getName_txt(),
                    entity.getAddress_txt(),
                    entity.getMobilenumber_txt()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean update(ManageProducerDto Dto) throws SQLException, ClassNotFoundException {
        return producerDao.update(new Producer(Dto.getProducerid_txt(), Dto.getName_txt(), Dto.getAddress_txt(), Dto.getMobilenumber_txt()));
    }



    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return producerDao.delete(String.valueOf(new Producer(id)));
    }
}
