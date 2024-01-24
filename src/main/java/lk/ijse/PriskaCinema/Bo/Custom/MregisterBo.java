package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.Dao.CrudDAO;
import lk.ijse.PriskaCinema.dto.LoginDto;
import lk.ijse.PriskaCinema.entity.Admin;

import java.sql.SQLException;

public interface MregisterBo extends SuperBo {
    boolean save(LoginDto admin) throws SQLException, ClassNotFoundException;
}
