package lk.ijse.PriskaCinema.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ManageMoviesDto {

    private String id_txt;
    private String name_txt;
    private String genre_txt;
    private String duration_txt;
    private String time_txt;

}
