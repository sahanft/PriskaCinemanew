package lk.ijse.PriskaCinema.Bo.Custom;

import lk.ijse.PriskaCinema.Bo.SuperBo;
import lk.ijse.PriskaCinema.dto.EmployeeRegisterDTO;
import lk.ijse.PriskaCinema.entity.User;

import java.sql.SQLException;

public interface EregisterBo extends SuperBo {
    boolean saveER(EmployeeRegisterDTO user) throws SQLException, ClassNotFoundException;
}
