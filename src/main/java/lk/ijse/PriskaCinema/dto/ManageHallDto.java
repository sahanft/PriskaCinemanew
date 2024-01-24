package lk.ijse.PriskaCinema.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ManageHallDto {

    private String number_txt;
    private String category_txt;
    private String count_txt;

    public ManageHallDto(String id) {
        this.number_txt = id;
    }
}
