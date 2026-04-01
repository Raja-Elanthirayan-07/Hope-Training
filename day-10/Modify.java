class Person {
    public String name;          
    protected int age;            
    String address;               
    private String secretId;      

    public Person(String name, int age, String address, String secretId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.secretId = secretId;
    }

    public String getSecretId() {
        return secretId;
    }

    private void privateMethod() {
        System.out.println("This is a private method in Person");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method in Person (Age: " + age + ")");
    }

    void defaultMethod() {
        System.out.println("This is a default method in Person");
    }
}

class Employee extends Person {
    public String employeeId;

    public Employee(String name, int age, String address, String secretId, String employeeId) {
        super(name, age, address, secretId);
        this.employeeId = employeeId;
    }

    public void showDetails() {
        System.out.println("--- Employee Details ---");
        System.out.println("Name (public): " + name);
        System.out.println("Age (protected): " + age);
        System.out.println("Address (default/package-private): " + address);
        
        System.out.println("Secret ID (private accessed via public method): " + getSecretId());
    }
}

public class Modify {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 28, "123 Main St", "SECRET_XYZ", "E-999");
        
        emp.showDetails();

        System.out.println("\n--- Testing Method Accessibility from Main ---");
        emp.protectedMethod(); 
        emp.defaultMethod();   
        
    }
}
