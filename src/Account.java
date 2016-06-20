
public class Account {
    private float amount;

    public Account(float value){
        this.amount = value;
    }

    public float getAmount(){
        return this.amount;
    }

    public void WithdrawMoney(float amountToWithdraw){
        amount-=amountToWithdraw;
    }

    public void ShowMoneyOnAccount(){
        //ИЗМЕНИТЬ ДЛЯ ГУИ
        System.out.println("HRN: " + amount + "\nUSD: " + Money.CalculateInUSD(amount) + "\nEuro: " + Money.CalculateInEuro(amount));
    }

    public String toString(){
        return "HRN: " + amount + "\nUSD: " + Money.CalculateInUSD(amount) + "\nEuro: " + Money.CalculateInEuro(amount);
    }
}
