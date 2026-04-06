public class AutoBoxing {
    public static void main(String[] args) {

        int a = 10;
        System.out.println(a);

        Integer objA = a;   
        System.out.println(objA);

        Integer x = 1000;
        Integer obj = 1000;

        System.out.println(x == obj);
        System.out.println(x.equals(obj));

        Float f = 127.5f;
        Float F = 127.5f;

        System.out.println(f == F);
    }
}