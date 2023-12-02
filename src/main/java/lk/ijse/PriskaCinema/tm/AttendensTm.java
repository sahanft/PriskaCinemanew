package lk.ijse.PriskaCinema.tm;

import lombok.*;
import javafx.scene.control.Button;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class AttendensTm {

    private String id_tm;
    private String name_tm;
    private Button delete_btn;
    private boolean isPresent;

    public AttendensTm(String id_tm, String name_tm, Button delete_btn) {
        this.id_tm = id_tm;
        this.name_tm = name_tm;
        this.delete_btn = delete_btn;
    }

}





