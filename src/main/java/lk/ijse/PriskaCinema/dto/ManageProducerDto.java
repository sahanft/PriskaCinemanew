package lk.ijse.PriskaCinema.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class ManageProducerDto {

    private String producerid_txt;
    private String name_txt;
    private String address_txt;
    private String mobilenumber_txt;

    public ManageProducerDto(String producerid_txt, String name_txt, String address_txt, String mobilenumber_txt) {
        this.producerid_txt = producerid_txt;
        this.name_txt = name_txt;
        this.address_txt = address_txt;
        this.mobilenumber_txt = mobilenumber_txt;
    }

    public ManageProducerDto(String id) {
        this.producerid_txt = id;
    }

    public String getId_txt() {
        return producerid_txt;
    }

    public String getContact_txt() {
        return mobilenumber_txt;
    }
}











