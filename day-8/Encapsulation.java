

class Encap {
    int a;

    public Encap() {
        a=10;
    }
    void display(){
        System.out.println("Implementation of Encapsulation: "+a);
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Encap obj = new Encap();
        obj.display();
    }
}