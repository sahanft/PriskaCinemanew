package lk.ijse.PriskaCinema.model;

import lk.ijse.PriskaCinema.db.DbConnection;
import lk.ijse.PriskaCinema.dto.ManageMoviesDto;
/*import lk.ijse.PriskaCinema.dto.ManageProducerDto;*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageMoviesModel {


    public static boolean saveMovie(ManageMoviesDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Movies VALUES(?,?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getId_txt());
        ptm.setString(2, dto.getName_txt());
        ptm.setString(3, dto.getGenre_txt());
        ptm.setString(4, dto.getDuration_txt());
        ptm.setString(5, dto.getTime_txt());


        return ptm.executeUpdate()>0;
    }

    public static List<ManageMoviesDto> loadAllmovie() throws SQLException {
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

    public static ArrayList<ManageMoviesDto> getAllmovie() throws SQLException {
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

    public static boolean updateMovie(ManageMoviesDto Dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Movies SET id = ?, name = ?, genre = ?, duration = ?, time = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, Dto.getId_txt());
        pstm.setString(2, Dto.getName_txt());
        pstm.setString(3, Dto.getGenre_txt());
        pstm.setString(4, Dto.getDuration_txt());
        pstm.setString(5, Dto.getTime_txt());

        return pstm.executeUpdate() > 0;
    }



    public static boolean deleteMovie(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Movies WHERE movie_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }


}
