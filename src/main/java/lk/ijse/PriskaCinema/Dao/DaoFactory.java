package lk.ijse.PriskaCinema.Dao;


import lk.ijse.PriskaCinema.Dao.Impl.*;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTyps{
        EMPLOYEE,HALL,MOVIE,PARKING,PRODUCER,SEAT,TICKET,EREGISTER,MREGISTER
    }

    public SupperDAO getDAO(DaoTyps daoTypes){
        switch (daoTypes) {
            case EMPLOYEE:
                return new EmployeeDaoImpl();
            case HALL:
                return new HallDaoImpl();
            case MOVIE:
                return new MovieDaoImpl();
            case PARKING:
                return new ParkingDaoImpl();
            case PRODUCER:
                return new ProducerDaoImpl();
            case SEAT:
                return new SeatDaoImpl();
            case TICKET:
                return new TicketDaoImpl();
            case EREGISTER:
                return new EregisterDaoImpl();
            case MREGISTER:
                return new MregisterDaoImpl();
            default:
                return null;
        }
    }

}
