public class CheckedException{
    public static void main(String[] args){
        try {
            int a=10/0;
            System.out.println(a);
        } 
        
        catch  (ArithmeticException e){
                System.out.println("Arithmetic Exception occurred: " + e.getMessage()); 
        }

        catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        

    }

}