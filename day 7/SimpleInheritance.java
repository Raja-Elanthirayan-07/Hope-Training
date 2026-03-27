class Parent{
    void display(){
        System.out.println("I am inside Parent class but called by child class");
    }
}
class child extends Parent{
    void display1(){
        System.out.println("I am inside child class");
    }
}
public class SimpleInheritance {
    public static void main(String[] args) {
        System.out.println("I am inside Main Function");
        child c = new child();
        c.display();
    }
}
