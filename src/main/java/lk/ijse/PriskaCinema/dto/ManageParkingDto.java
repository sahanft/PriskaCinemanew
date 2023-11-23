package lk.ijse.PriskaCinema.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ManageParkingDto {

    private String spacemen_txt;
    private String type_txt;
    private String parkingfee_txt;
    private LocalDate date_txt;


}
