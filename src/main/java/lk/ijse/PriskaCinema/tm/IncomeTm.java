package lk.ijse.PriskaCinema.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class IncomeTm {
    private String id;
    private String description;
    private String month;
    private Double amount;

}
