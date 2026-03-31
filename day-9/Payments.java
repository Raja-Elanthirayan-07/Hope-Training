interface Payment {
    void pay(double amount);
}

class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using UPI.");
    }
}

class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class DebitCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Debit Card.");
    }
}

class Cash implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in Cash.");
    }
}

public class Payments {
    public static void main(String[] args) {
        Payment upi = new UPIPayment();
        Payment cc = new CreditCard();
        Payment dc = new DebitCard();
        Payment cash = new Cash();

        upi.pay(100.50);
        cc.pay(250.00);
        dc.pay(50.75);
        cash.pay(20.00);
    }
}
