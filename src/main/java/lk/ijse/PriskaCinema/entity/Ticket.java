package lk.ijse.PriskaCinema.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor


public class Ticket {



    private String ticketnumber_txt;
    private String tickettype_txt;
    private String movieid_txt;
    private String screen_txt;
    private Double price_txt;
    private String empid_txt;
    private String time_txt;
    private LocalDate date_txt;

    public Ticket(String ticketnumber, String tickettype, String movieid, String screen, Double price, String empid, String time, LocalDate date) {
        this.ticketnumber_txt = ticketnumber;
        this.tickettype_txt = tickettype;
        this.movieid_txt = movieid;
        this.screen_txt = screen;
        this.price_txt = price;
        this.empid_txt = empid;
        this.time_txt = time;
        this.date_txt = date;
    }
    public Ticket(String ticketnumber) {
        this.ticketnumber_txt = ticketnumber;
    }



}
