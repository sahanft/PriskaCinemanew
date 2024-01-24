package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.MregisterBo;
import lk.ijse.PriskaCinema.Dao.Custom.MregisterDao;
import lk.ijse.PriskaCinema.Dao.DaoFactory;
import lk.ijse.PriskaCinema.dto.LoginDto;
import lk.ijse.PriskaCinema.entity.Admin;

import java.sql.SQLException;

public class MregisterBoImpl implements MregisterBo {
    MregisterDao mregisterDao = (MregisterDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.MREGISTER);
    @Override
    public boolean save(LoginDto admin) throws SQLException, ClassNotFoundException {
        return mregisterDao.save(new Admin(admin.getUserName(),admin.getPassword()));
    }
}
