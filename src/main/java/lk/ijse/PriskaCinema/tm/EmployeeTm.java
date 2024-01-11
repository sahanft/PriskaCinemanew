package lk.ijse.PriskaCinema.tm;

import lombok.*;


@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeTm {

    private String empid;
    private String empname;
    private String jobtype;
    private int mobile;
    private String nic;
    private double salary;
    private String address;

    public EmployeeTm(String empidTxt, String empnameTxt, String empjobtypeTxt, int empmobileTxt, String empnicTxt, double empsalaryTxt, String empaddressTxt) {
        this.empid = empidTxt;
        this.empname = empnameTxt;
        this.jobtype = empjobtypeTxt;
        this.mobile = empmobileTxt;
        this.nic = empnicTxt;
        this.salary = empsalaryTxt;
        this.address = empaddressTxt;
    }

    public EmployeeTm(String id, String name, String jobtype, String mobile, String nic, double salary, String address) {
        this.empid = id;
        this.empname = name;
        this.jobtype = jobtype;
        this.mobile = Integer.parseInt(mobile);
        this.nic = nic;
        this.salary = salary;
        this.address = address;
    }
}
