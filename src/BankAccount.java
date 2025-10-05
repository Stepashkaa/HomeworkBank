import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {

    private String name;

    private int balance;

    private LocalDateTime dateOpen;

    private boolean blocked;

    private String number;

    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
        this.dateOpen = LocalDateTime.now();
        this.blocked = false;
        this.number = generateNumber();
    }

    public boolean deposit(int amount){
        if (blocked || amount <= 0){
            return false;
        }
        else {
            balance += amount;
        }
        return true;
    }

    public boolean withdraw(int amount){
        if (amount > balance || amount <= 0 || blocked){
            return false;
        }
        else{
            balance -= amount;
        }
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount){
        if (this.blocked || otherAccount.blocked){
            return false;
        }
        this.withdraw(amount);
        otherAccount.deposit(amount);
        return true;
    }

    public String generateNumber(){
        Random random = new Random();
        StringBuilder str1 = new StringBuilder();
        for(int i = 0; i < 8; i++){
            str1.append((random.nextInt(8)));
        }
        return str1.toString();
    }

    @Override
    public String toString(){
        return "BankAccount{" +
                "owner='" + name + '\'' +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", openedAt=" + dateOpen +
                ", blocked=" + blocked +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        else if(!(obj instanceof BankAccount)){
            return false;
        }
        BankAccount that = (BankAccount) obj;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean getBlocked(){
        return blocked;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
