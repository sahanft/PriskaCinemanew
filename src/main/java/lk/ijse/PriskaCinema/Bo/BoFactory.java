package lk.ijse.PriskaCinema.Bo;


import lk.ijse.PriskaCinema.Bo.Impl.*;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getBoFactory(){
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTyps{
        EMPLOYEE,HALL,MOVIE,PARKING,PRODUCER,SEAT,TICKET,EREGISTER,MREGISTER
    }

    public SuperBo getBo(BoTyps boTyps){
        switch (boTyps) {
            case EMPLOYEE:
                return new EmployeeBoImpl();
            case HALL:
                return new HallBoImpl();
            case MOVIE:
                return new MovieBoImpl();
            case PARKING:
                return new ParkingBoImpl();
            case PRODUCER:
                return new ProducerBoImpl();
            case SEAT:
                return new SeatBoImpl();
            case TICKET:
                return new TicketBoImpl();
            case EREGISTER:
                return new EregisterBoImpl();
            case MREGISTER:
                return new MregisterBoImpl();
            default:
                return null;
        }
    }

}
