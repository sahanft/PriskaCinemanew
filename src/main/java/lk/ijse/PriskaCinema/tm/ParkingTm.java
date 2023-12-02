package lk.ijse.PriskaCinema.tm;

import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ParkingTm {

    private String spaceNum;
    private String type;
    private Double parkingFee;
    private LocalDate date;




}
