package be.heh.epm.adapter.web;


public class EmployeeSalariedValidating {

    private int empId = 100 ;

    private String name = "toto";

    private String address = "av maistriau";

    private String mail = "toto@heh.be";

    private double monthlySalary = 1500;

    public EmployeeSalariedValidating (){

    }

    public EmployeeSalariedValidating (int empId, String name, String address, String mail, int monthlySalary){
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.monthlySalary = monthlySalary;
    }



    public int getId() {
        return empId;
    }

    public void setId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}