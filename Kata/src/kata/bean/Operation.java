package kata.bean;

/*
    Classe Opération contenant les informations suivantes concernant l'opération:
    Son type, sa date, son montant, et le solde restant
*/
public class Operation{
    private String type;
    private String date;
    private double amount;
    private double wealth;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getWealth() {
        return wealth;
    }

    public void setWealth(double wealth) {
        this.wealth = wealth;
    }
}