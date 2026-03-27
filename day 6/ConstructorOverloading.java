class cOVERLOADING{
    cOVERLOADING(){
        System.out.println("Default ConstructorOverloading");
    }
    cOVERLOADING(int i){
        System.out.println("Parameterized constructor and overloading,the value of i is "+i);
    }
    cOVERLOADING(String i){
        System.out.println("Parameterized constructor and overloading,the value of i is "+i);
    }
}
public class ConstructorOverloading {

    public static void main(String[] args) {
        System.out.println("Constructor Overloading Examples");
        cOVERLOADING cr = new cOVERLOADING();
        cOVERLOADING cr1 = new cOVERLOADING(5);
        cOVERLOADING cr2 = new cOVERLOADING("Hope batch 1");
    }
}