
public class Account {
    private float amount;

    public Account(float value){
        this.amount = value;
    }

    public void showMoneyOnAccount(){
        //ИЗМЕНИТЬ ДЛЯ ГУИ
        System.out.println("HRN: " + amount + "\nUSD: " + Money.CalculateInUSD(amount) + "\nEuro: " + Money.CalculateInEuro(amount));
    }

    public String toString(){
        return "HRN: " + amount + "\nUSD: " + Money.CalculateInUSD(amount) + "\nEuro: " + Money.CalculateInEuro(amount);
    }
}
