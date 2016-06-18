import Exceptions.WrongPasswordException;

import java.util.Scanner;

public class ATM {

    private Person curUser;
    private String enteredPassword;

    private class Security{
        private Card.Type validType = Card.Type.MasterCard;

        //exception сделать обычный или runtime ?
        public boolean checkCardValidation(){
            if(curUser.getPersonCard().getType()!=validType)
                return false;
            return true;
        }

        //!!!!ИЗМЕНИТЬ ДЛЯ GUI
        public void checkPassword()throws WrongPasswordException{
            if (!enteredPassword.equals(curUser.getPersonCard().getCardPassword()))
                throw new WrongPasswordException("You've entered wrong password!");
        }
    }

    //!!!ИЗМЕНИТЬ ДЛЯ GUI
    public void enterPassword(){
        System.out.println("enter password:");
        Scanner in = new Scanner(System.in);
        this.enteredPassword = in.nextLine();
    }

}
