package lk.ijse.PriskaCinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Parking {

    private String spacemen_txt;
    private String type_txt;
    private double parkingfee_txt;
    private LocalDate date_txt;

    public Parking(String spaceNum, String type, Double parkingfee, LocalDate date) {
        this.spacemen_txt = spaceNum;
        this.type_txt = type;
        this.parkingfee_txt = parkingfee;
        this.date_txt = date;
    }

    public Parking(String spaceNum) {
        this.spacemen_txt = spaceNum;
    }
}


