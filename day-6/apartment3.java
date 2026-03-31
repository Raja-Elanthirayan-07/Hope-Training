class dConstruct{
  dConstruct(int x){
       if(x==1){
        System.out.println("1st apartment has 1 kitchen, 1 dining hall,1 bedroom,1 restroom,1 hall and 1 public playground");

       }
       else if(x==2){
        System.out.println("2nd apartment has 1 kitchen with  dining hall,2 bedroomwith attached restroom,1 public hall and 1 public playground");
        
       }
       else if(x==4){
        System.out.println("3rd apartment has 1 kitchen and dining hall,4 bedroom with attached 4 restroom,1 hall for each 2 bedroom and 1 public playground");
        
       }

    }
}
public class apartment3{
   
    public static void main(String[] args) {
       new dConstruct(1);
        new dConstruct(2);
        new dConstruct(4);
        
    }
}
