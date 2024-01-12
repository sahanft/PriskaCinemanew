package lk.ijse.PriskaCinema.entity;

import lombok.*;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor
public class movie {

    private String id_txt;
    private String name_txt;
    private String genre_txt;
    private String duration_txt;
    private String time_txt;

    public movie(String id, String name, String genre, String duration, String time) {
        this.id_txt = id;
        this.name_txt = name;
        this.genre_txt = genre;
        this.duration_txt = duration;
        this.time_txt = time;
    }

    public movie(String id) {
        this.id_txt = id;
    }

}
