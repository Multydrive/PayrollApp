package be.heh.epm.domain;
public class MailMethod implements PaymentMethod{
    private String email;
    public MailMethod(String mail){
        this.email = mail;
    }
    @Override
    public String toString(){
        return "mail : " + this.email;
    }
}