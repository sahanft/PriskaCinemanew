package lk.ijse.PriskaCinema.dto;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Seat1Dto {
    private String seatnumber_txt;
    private String screen_txt;
    private String rownumber_txt;

    public Seat1Dto(String id) {
        this.seatnumber_txt = id;
    }
}







