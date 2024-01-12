package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.MovieDao;
import lk.ijse.PriskaCinema.Dao.SqlUtil;
import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
import lk.ijse.PriskaCinema.dto.ProducerDetailsDto;
import lk.ijse.PriskaCinema.entity.ProducerDetails;
import lk.ijse.PriskaCinema.entity.movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    public boolean save(movie dto) throws SQLException, ClassNotFoundException {

        return SqlUtil.test("INSERT INTO Movies VALUES(?,?,?,?,?)",
                dto.getId_txt(), dto.getName_txt(), dto.getGenre_txt(), dto.getDuration_txt(), dto.getTime_txt());
    }


    @Override
    public ArrayList<movie> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<movie> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<movie> itemList = new ArrayList<>();
        ResultSet resultSet = SqlUtil.test("SELECT * FROM Movies");

        while (resultSet.next()) {
            itemList.add(new movie(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }

        return itemList;
    }


    public boolean update(movie Dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE Movies SET  name = ?, genre = ?, duration = ?, time = ? where movie_id = ?",
                Dto.getName_txt(), Dto.getGenre_txt(), Dto.getDuration_txt(), Dto.getTime_txt(), Dto.getId_txt());
    }



    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Movies WHERE movie_id = ?", id);
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean saveProducerMovieDetails(ProducerDetails producerDetailsDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into ProducerDetails values(?,?)");
        preparedStatement.setObject(1, producerDetailsDto.getPro_id());
        preparedStatement.setObject(2, producerDetailsDto.getMovie_id());
        return preparedStatement.executeUpdate()>0;
    }

}
