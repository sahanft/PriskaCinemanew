package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.ProducerDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageProducerDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;
import lk.ijse.PriskaCinema.entity.Producer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerDaoImpl implements ProducerDao {

    public boolean save(Producer dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("INSERT INTO Producers VALUES(?,?,?,?)",
               dto.getProducerid_txt(), dto.getName_txt(), dto.getAddress_txt(), dto.getMobilenumber_txt());
    }



    public ArrayList<Producer> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM Seats");
        ArrayList<Producer> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new Producer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)

                    )
            );
        }
        return dtoList;

    }

    @Override
    public ArrayList<Producer> loadAll() throws SQLException {
        return null;
    }

    public boolean update(Producer Dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("UPDATE Producers SET name = ?, pro_address = ?, pro_tele = ? WHERE pro_id = ?",
               Dto.getName_txt(), Dto.getAddress_txt(), Dto.getMobilenumber_txt(), Dto.getProducerid_txt());
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test( "DELETE FROM Producers WHERE pro_id = ?", id);
    }

    @Override
    public boolean saveProducerMovieDetails(Producer producerDetailsDto) throws SQLException, ClassNotFoundException {
        return false;
    }


}
