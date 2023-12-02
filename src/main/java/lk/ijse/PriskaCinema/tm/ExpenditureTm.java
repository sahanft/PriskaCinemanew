package lk.ijse.PriskaCinema.tm;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString




public class ExpenditureTm {
    private String id2;
    private String description2;
    private String month2;
    private Double amount2;

    public ExpenditureTm(String expenditureTxt, String description2Txt, String month2Txt, String amount2Txt) {
    }
}
