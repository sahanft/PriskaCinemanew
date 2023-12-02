package lk.ijse.PriskaCinema.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class ManageParkingDto {

    private String spacemen_txt;
    private String type_txt;
    private double parkingfee_txt;
    private LocalDate date_txt;

    public ManageParkingDto(String spaceNum, String type, Double parkingfee, LocalDate date) {
        this.spacemen_txt = spaceNum;
        this.type_txt = type;
        this.parkingfee_txt = parkingfee;
        this.date_txt = date;
    }

    public ManageParkingDto(String rownumber, String screen, String seatnumber) {
    }
}


