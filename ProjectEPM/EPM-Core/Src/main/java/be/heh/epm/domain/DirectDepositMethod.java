package be.heh.epm.domain;
import lombok.Getter;
import lombok.Setter;
public class DirectDepositMethod implements PaymentMethod {
    @Getter @Setter
    private String bank;
    @Getter @Setter
    private String accountNumber;

    public DirectDepositMethod(String bank, String acc){
        this.bank = bank;
        this.accountNumber = acc;
    }

    @Override
    public String toString(){
        return "direct deposit into " + this.bank + " : " + this.accountNumber;
    }
}
