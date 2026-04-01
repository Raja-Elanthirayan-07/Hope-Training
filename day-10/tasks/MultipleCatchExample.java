public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException");
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException");
        } catch (Exception e) {
            System.out.println("Caught a general Exception: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}