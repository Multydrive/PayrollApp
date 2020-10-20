package be.heh.epm.domain;
public class DirectDepositMethod implements PayMethod {
    private String bank;
    private String accountNumber;
    public DirectDepositMethod(String bank, String acc){}
    @Override
    public String toString(){}
}
