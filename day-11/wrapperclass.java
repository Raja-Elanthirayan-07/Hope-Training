
public class wrapperclass {
    public static void main(String[] args) {
        int a=10;
        System.out.println(a);
        Integer objA=Integer.valueOf(a);
        System.out.println(objA);
        System.out.println(a==objA);
        System.out.println(objA.hashCode());
       
    }
}