package lk.ijse.PriskaCinema.entity;

import lombok.*;


@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor


public class Seat {
    private String seatnumber_txt;
    private String screen_txt;
    private String rownumber_txt;

    public Seat(String seatnumber, String screen, String rownumber) {
        this.seatnumber_txt = seatnumber;
        this.screen_txt = screen;
        this.rownumber_txt = rownumber;
    }

    public Seat(String seatnumber) {
        this.seatnumber_txt = seatnumber;
    }
}







