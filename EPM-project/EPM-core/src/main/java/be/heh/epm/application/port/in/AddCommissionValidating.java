package be.heh.epm.application.port.in;

import be.heh.epm.common.SelfValidating;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AddCommissionValidating extends SelfValidating<AddCommissionValidating> {
    @NotNull
    @Getter
    private int empId;
    @NotNull
    @Getter
    private String name;
    @NotNull
    @Getter
    private String address;
    @NotNull
    @Email
    @Getter
    private String mail;
    @NotNull
    @Getter
    private double monthlySalary;
    @NotNull
    @Getter
    private double commission_rate;
    @NotNull
    @Getter
    private String bank;
    @NotNull
    @Getter
    private String account;


    public AddCommissionValidating(int empId, String name, String address, String mail, double monthlySalary, String bank, String account, double commission_rate) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.monthlySalary = monthlySalary;
        this.bank = bank;
        this.account = account;
        this.commission_rate = commission_rate;
        this.validateSelf();
    }
}


