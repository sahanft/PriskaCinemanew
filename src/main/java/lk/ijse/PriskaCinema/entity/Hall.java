package lk.ijse.PriskaCinema.entity;

import lombok.*;

@Getter
@Setter
@ToString

@NoArgsConstructor

public class Hall {

    private String number_txt;
    private String category_txt;
    private String count_txt;

    public Hall(String number, String category, String count) {
        this.number_txt = number;
        this.category_txt = category;
        this.count_txt = count;
    }

    public Hall(String number) {
        this.number_txt = number;
    }

}
