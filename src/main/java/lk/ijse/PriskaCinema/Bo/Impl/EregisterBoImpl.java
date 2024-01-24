package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.EregisterBo;
import lk.ijse.PriskaCinema.Dao.Custom.EregisterDao;
import lk.ijse.PriskaCinema.Dao.DaoFactory;
import lk.ijse.PriskaCinema.dto.EmployeeRegisterDTO;
import lk.ijse.PriskaCinema.entity.User;

import java.sql.SQLException;

public class EregisterBoImpl implements EregisterBo{
    EregisterDao eregisterDao = (EregisterDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.EREGISTER);
    @Override
    public boolean saveER(EmployeeRegisterDTO user) throws SQLException, ClassNotFoundException {
        return eregisterDao.save(new User(user.getUsername(),user.getPassword()));
    }
}
