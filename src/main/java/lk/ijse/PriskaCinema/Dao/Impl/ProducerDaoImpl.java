package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.ProducerDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;
import lk.ijse.PriskaCinema.entity.Producer;
import lk.ijse.PriskaCinema.entity.ProducerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerDaoImpl implements ProducerDao {

    @Override
    public boolean save(Producer dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("INSERT INTO Producers VALUES(?,?,?,?)",
               dto.getProducerid_txt(), dto.getName_txt(), dto.getAddress_txt(), dto.getMobilenumber_txt());
    }


    @Override
    public ArrayList<Producer> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM Producers");
        ArrayList<Producer> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            Producer producer = new Producer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4));
            dtoList.add(producer);
        }
        return dtoList;

    }

    @Override
    public ArrayList<Producer> loadAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Producer Dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("UPDATE Producers SET name = ?, pro_address = ?, pro_tele = ? WHERE pro_id = ?",
               Dto.getName_txt(), Dto.getAddress_txt(), Dto.getMobilenumber_txt(), Dto.getProducerid_txt());
    }

    @Override
    public boolean delete(Producer id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test( "DELETE FROM Producers WHERE pro_id = ?", id.getProducerid_txt());
    }

    @Override
    public boolean saveProducerMovieDetails(ProducerDetails dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO ProducerDetails VALUES(?,?)",dto.getProducerid_txt(),dto.getMovie_id());
    }


}
