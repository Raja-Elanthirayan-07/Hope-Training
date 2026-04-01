class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}
class Bank{
    private double balance;
    void deposit(int amount) throws InsufficientBalanceException{ 
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited: " + amount + ", Current Balance: " + balance);
        }else if(amount<=0){
            throw new InsufficientBalanceException("Amount cant be 0 or negative");
        }
    }
    void withdraw(int amount) throws InsufficientBalanceException{
        if(balance < 0){
            throw new InsufficientBalanceException("Balance insufficient");
        }else if(amount > balance){
            throw new InsufficientBalanceException("Amount is higher than balance");
        }else{
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Current Balance: " + balance);
        }
    }
}
public class throwsExceptionExample {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        
        try {
            myBank.deposit(1000);
        
            myBank.withdraw(400);
            
            myBank.withdraw(800);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        try {
            // Invalid deposit - raises exception
            myBank.deposit(-200);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
