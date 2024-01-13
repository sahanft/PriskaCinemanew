package lk.ijse.PriskaCinema.Bo.Impl;

import lk.ijse.PriskaCinema.Bo.Custom.EmployeeBo;
import lk.ijse.PriskaCinema.Dao.Custom.EmployeeDao;
import lk.ijse.PriskaCinema.Dao.Impl.EmployeeDaoImpl;
import lk.ijse.PriskaCinema.dto.employeeDto;
import lk.ijse.PriskaCinema.entity.employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {

    EmployeeDao employeeDao =  new EmployeeDaoImpl();


    @Override
    public boolean save(employeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(new employee(
                dto.getEmpid_txt(), dto.getEmpname_txt(), dto.getEmpjobtype_txt(), dto.getEmpmobile_txt(),
                dto.getEmpnic_txt(),dto.getEmpsalary_txt(),dto.getEmpaddress_txt()));
    }

    @Override
    public List<employeeDto> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<employee> list =  employeeDao.loadAll();
        ArrayList<employeeDto> dtos = new ArrayList<>();

        for (employee entity: list) {
            dtos.add(new employeeDto(
                    entity.getEmpid_txt(),
                    entity.getEmpname_txt(),
                    entity.getEmpjobtype_txt(),
                    entity.getEmpmobile_txt(),
                    entity.getEmpnic_txt(),
                    entity.getEmpsalary_txt(),
                    entity.getEmpaddress_txt()
            ));
        }
        return dtos;
    }

    @Override
    public ArrayList<employeeDto> getAll() throws SQLException {

        ArrayList<employee> list =  employeeDao.getAll();
        ArrayList<employeeDto> dtoList = new ArrayList<>();

        for (employee entity: list) {
            dtoList.add(new employeeDto(
                    entity.getEmpid_txt(),
                    entity.getEmpname_txt(),
                    entity.getEmpjobtype_txt(),
                    entity.getEmpmobile_txt(),
                    entity.getEmpnic_txt(),
                    entity.getEmpsalary_txt(),
                    entity.getEmpaddress_txt()
            ));
        }
        return dtoList;
    }


    @Override
    public boolean delete(employeeDto id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(new employee(id.getEmpid_txt()));
    }

    @Override
    public boolean update(employeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(new employee(dto.getEmpid_txt(), dto.getEmpname_txt(), dto.getEmpjobtype_txt(), dto.getEmpmobile_txt(),
                dto.getEmpnic_txt(),dto.getEmpsalary_txt(),dto.getEmpaddress_txt()));
    }
}
