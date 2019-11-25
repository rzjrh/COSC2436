

public class CreditCard {

    private Money balance;
    private Money creditLimit;
    private Person owner;

    public CreditCard(Person creditCardHolder, Money limit){
        balance = new Money(0);
        this.owner = creditCardHolder;
        this.creditLimit = limit;
    }

    public Money getBalance(){
        return new Money(this.balance);
    }

    public Money getCreditLimit(){
        return new Money(this.creditLimit);
    }

    public String getPersonals(){
        return owner.toString();
    }

    public void charge(Money amount){

        if(balance.add(amount).compareTo(creditLimit) < 0) {
            balance = balance.add(amount);
        }
        else {
            System.out.println("Exceeds Credit Limit!");
        }
    }

    public void payment(Money amount){
        balance = balance.subtract(amount);
    }
}
