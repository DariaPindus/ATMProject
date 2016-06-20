import Exceptions.OutOfMoneyException;

public class ATMTest {

    public static void main(String[] args) throws OutOfMoneyException {
        Person newPerson;
        newPerson = new Person("Jack");
        newPerson.setCard("124211", Card.Type.MasterCard, 1200, "password");
       //ATM с помощью фабричного метода
        ATM testATM = new ATM(newPerson);
        try{
            testATM.EnterPassword();
            testATM.GetMoney(500);
            testATM.ShowAccount();
        }
        catch (OutOfMoneyException e){
            System.out.println(e.getMessage());
        }
    }
}
