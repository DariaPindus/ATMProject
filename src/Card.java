
public class Card {
    private String ID;
    private String cardPassword;
    //можно ли так сделать???
    public static enum Type {MasterCard, Visa};
    private Type type;
    private Account currAccount;

    //???имеет ли смысл тут билдер?
    public static class Builder{
        private String ID;
        private String cardPassword;
        private Type type;
        private Account currAccount;

        public Builder(String ID, Type type){
            this.ID = ID;
            this.type = type;
        }
        public Builder cardPassword(String value){
            this.cardPassword = value;
            return this;
        }
        public Builder currAccount(float value){
            this.currAccount = new Account(value);
            return this;
        }

        public Card build(){
            return new Card(this);
        }
    }

    private Card(Builder builder){
        this.ID = builder.ID;
        this.type = builder.type;
        this.currAccount = builder.currAccount;
        this.cardPassword = builder.cardPassword;
    }

    public Type getType(){ return this.type; }

    public String getCardPassword(){
        return this.cardPassword;
    }
    public void setId(String id) {
        ID = id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCurrAccount(float value){
        currAccount = new Account(value);
    }

    public Account getCurrAccount(){
        return currAccount;
    }
}
