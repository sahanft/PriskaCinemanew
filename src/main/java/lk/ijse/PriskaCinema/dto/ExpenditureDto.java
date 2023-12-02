package lk.ijse.PriskaCinema.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExpenditureDto {

    private String expenditure_txt;
    private String description2_txt;
    private String month2_txt;
    private String amount2_txt;


    public ExpenditureDto(String income2, String description2, String month2, double amount2) {
        this.expenditure_txt = income2;
        this.description2_txt = description2;
        this.month2_txt = month2;
        this.amount2_txt = String.valueOf(amount2);
    }
}
