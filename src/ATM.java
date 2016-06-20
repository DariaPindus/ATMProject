import Exceptions.OutOfMoneyException;
import Exceptions.WrongPasswordException;

import java.util.Calendar;
import java.util.Scanner;

public class ATM {

    private Person curUser;
    private Card currentCard;
    private String enteredPassword;
    private Calendar currentDate;

    public enum TypeOfOperation {Withdrawal, Transfer, Payments }

    //????можно ли избежать здесь создания этого класса7??
    private Security thisSecurity = new Security();

    public ATM(Person person) {
        curUser = person;
        currentCard = curUser.getPersonCard();
    }

    private class Security {
        private Card.Type validType = Card.Type.MasterCard;

        //exception сделать обычный или runtime ?
        public boolean CheckCardValidation() {
            if (currentCard.getType() != validType)
                return false;
            return true;
        }

        //!!!!ИЗМЕНИТЬ ДЛЯ GUI
        public void CheckPassword() throws WrongPasswordException {
            if (!enteredPassword.equals(currentCard.getCardPassword()))
                throw new WrongPasswordException("You've entered wrong password!");
        }

        private boolean IsEnoughMoney(float value) {
            if (value > currentCard.getCurrAccount().getAmount())
                return false;
            return true;
        }
    }

    public void ShowAccount() {
        System.out.println(curUser.getPersonCard().getCurrAccount());
    }

    public void TransferMoney(float value) throws OutOfMoneyException {
        System.out.println("Please, enter your recipient: ");
        Scanner scanner = new Scanner(System.in);
        String recipient = scanner.next();
        if (thisSecurity.IsEnoughMoney(value)) {
            currentCard.getCurrAccount().WithdrawMoney(value);
            //добавить сообщение об успешном снятии
            String message = value + " has been transferred to " + recipient;
            System.out.println(message);
        } else
            throw new OutOfMoneyException("There in't enough money on your account");
    }

    public void mobilePayment(){

    }

    public void GetMoney(float value) throws OutOfMoneyException {
        if (thisSecurity.IsEnoughMoney(value)) {
            currentCard.getCurrAccount().WithdrawMoney(value);
            //добавить сообщение об успешном снятии
            String message = value + " has been successfully withdrawn";
            System.out.println(message);
        } else
            throw new OutOfMoneyException("There in't enough money on your account");

    }

    //!!!ИЗМЕНИТЬ ДЛЯ GUI
    public void EnterPassword() {
        System.out.println("enter password:");
        Scanner in = new Scanner(System.in);
        this.enteredPassword = in.nextLine();
    }

}
