package lk.ijse.PriskaCinema.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class ManageTicketDto {



    private String ticketnumber_txt;
    private String tickettype_txt;
    private String movieid_txt;
    private String screen_txt;
    private Double price_txt;
    private String empid_txt;
    private String time_txt;
    private LocalDate date_txt;


    public ManageTicketDto(String id) {
        this.ticketnumber_txt = id;
    }
}
