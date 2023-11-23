package lk.ijse.PriskaCinema.tm;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TicketTm {

    private String ticketNum;
    private String tickettype;
    private String movieid;
    private String screen;
    private String price;
    private String empid;
    private String time;
    private LocalDate date;

}
