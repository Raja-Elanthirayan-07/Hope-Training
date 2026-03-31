class Apartment{
    void display(){
        System.out.println("I am in ApartmentClass");
    }
}
public class ClassObject {

    public static void main(String[] args) {
        System.out.println("I am in classObjectClass");
        Apartment apartment = new Apartment();
        apartment.display();
    }
}
