package lk.ijse.PriskaCinema.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class employee {

    private String empid_txt;
    private String empname_txt;
    private String empjobtype_txt;
    private int empmobile_txt;
    private String empnic_txt;
    private double empsalary_txt;
    private String empaddress_txt;


    public employee(String id, String name, String jobtype, String mobile, String nic, Double salary, String address) {
        this.empid_txt = id;
        this.empname_txt = name;
        this.empjobtype_txt = jobtype;
        this.empmobile_txt = Integer.parseInt(mobile);
        this.empnic_txt = nic;
        this.empsalary_txt = salary;
        this.empaddress_txt = address;

    }


    public employee(String id) {

        this.empid_txt = id;
    }
}
