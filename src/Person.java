import java.util.GregorianCalendar;

public class Person {
    private String name;
    private Card personCard;
    GregorianCalendar expireDate;

    public Person(String name, GregorianCalendar expireDate){
        this.name = name;
        this.expireDate = expireDate;
    }

    public void setCard(String CardID, Card.Type type, float initAmount, String password){
        /*personCard.setType(type);
        personCard.setId(CardID);
        personCard.setCurrAccount(initAmount);*/
        personCard = new Card.Builder(CardID, type).cardPassword(password).currAccount(initAmount).build();
    }

    public Card getPersonCard(){
        return this.personCard;
    }
}
