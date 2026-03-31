interface Animal {
    void makeSound();
    void sleep();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof woof!");
    }

    public void sleep() {
        System.out.println("Zzz...");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.sleep();
    }
}

