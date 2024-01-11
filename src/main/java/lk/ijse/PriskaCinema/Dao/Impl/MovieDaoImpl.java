package lk.ijse.PriskaCinema.Dao.Impl;

import lk.ijse.PriskaCinema.Dao.Custom.MovieDao;
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

public class MovieDaoImpl implements MovieDao {

    public boolean save(ManageMoviesDto dto) throws SQLException, ClassNotFoundException {

        return SqlUtil.test("INSERT INTO Movies VALUES(?,?,?,?,?)", dto.getId_txt(), dto.getName_txt(), dto.getGenre_txt(), dto.getDuration_txt(), dto.getTime_txt());
    }

   /* public static boolean saveMovieIdAssociate(ProducerDetailsDto producerDetailsDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO ProducerDetails VALUES(?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, producerDetailsDto.getPro_id());
        ptm.setString(2, producerDetailsDto.getMovie_id());

        return ptm.executeUpdate()>0;
    }*/


    @Override
    public ArrayList<ManageMoviesDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<ManageMoviesDto> loadAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Movies";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ManageMoviesDto> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new ManageMoviesDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }

        return itemList;
    }

    @Override
    public ArrayList<ManageMoviesDto> getAllmovie() throws SQLException {
        return null;
    }

    /*  public static ArrayList<ManageMoviesDto> getAllmovie() throws SQLException {
          Connection connection = DbConnection.getInstance().getConnection();

          String sql = "SELECT * FROM Movies";

          PreparedStatement pstm = connection.prepareStatement(sql);
          ResultSet resultSet = pstm.executeQuery();

          ArrayList<ManageMoviesDto> dtoList = new ArrayList<>();

          while(resultSet.next()) {
              dtoList.add(
                      new ManageMoviesDto(
                              resultSet.getString(1),
                              resultSet.getString(2),
                              resultSet.getString(3),
                              resultSet.getString(4),
                              resultSet.getString(5)

                      )
              );
          }
          return dtoList;

      }
  */
    public boolean update(ManageMoviesDto Dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE Movies SET  name = ?, genre = ?, duration = ?, time = ? where movie_id = ?", Dto.getName_txt(), Dto.getGenre_txt(), Dto.getDuration_txt(), Dto.getTime_txt(), Dto.getId_txt());
    }

    @Override
    public boolean delete(ManageMoviesDto manageMoviesDto) throws SQLException, ClassNotFoundException {
        return false;
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Movies WHERE movie_id = ?", id);
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean saveProducerMovieDetails(ProducerDetailsDto producerDetailsDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into ProducerDetails values(?,?)");
        preparedStatement.setObject(1, producerDetailsDto.getPro_id());
        preparedStatement.setObject(2, producerDetailsDto.getMovie_id());
        return preparedStatement.executeUpdate()>0;
    }

}
