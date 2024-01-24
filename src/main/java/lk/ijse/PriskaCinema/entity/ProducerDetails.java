package lk.ijse.PriskaCinema.entity;

import lombok.*;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor

public class ProducerDetails extends Producer {

    private String pro_id;
    private String movie_id;

    public ProducerDetails(String pro_id, String movie_id) {
        this.pro_id = pro_id;
        this.movie_id = movie_id;
    }

//    public ProducerDetailsDto(String id) {
//    }
}
