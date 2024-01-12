package lk.ijse.PriskaCinema.entity;

import lombok.*;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor

public class Producer {

    private String producerid_txt;
    private String name_txt;
    private String address_txt;
    private String mobilenumber_txt;

    public Producer(String id, String name, String address, String mobilenumber) {
        this.producerid_txt = id;
        this.name_txt = name;
        this.address_txt = address;
        this.mobilenumber_txt = mobilenumber;
    }
    public Producer(String id) {
        this.producerid_txt = id;
    }


}











