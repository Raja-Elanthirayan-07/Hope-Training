abstract class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    abstract void calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void calculateSalary() {
        System.out.println(name + "'s Full-Time salary is: $" + monthlySalary);
    }
}

class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    void calculateSalary() {
        System.out.println(name + "'s Part-Time salary is: $" + (hourlyRate * hoursWorked));
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Employee ft = new FullTimeEmployee("Alice", 5000);
        Employee pt = new PartTimeEmployee("Bob", 20, 80);

        ft.calculateSalary();
        pt.calculateSalary();
    }
}