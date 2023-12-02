package lk.ijse.PriskaCinema.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter


public class AttendansDto {
    private String date;
    private String id;
    private String name;
    private boolean isPresent;




}
