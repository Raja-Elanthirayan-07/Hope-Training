import java.util.Scanner;

class Encap{
    private String name;
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter name :");
        Scanner sc = new Scanner(System.in);
        Encap en = new Encap();
        en.setName(sc.nextLine());
        System.out.println(en.getName());
    }
}



