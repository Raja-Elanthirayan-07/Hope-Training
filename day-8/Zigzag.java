import java.util.Scanner;

public class Zigzag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int rows = sc.nextInt();

        String[] arr = new String[rows];
        boolean flag = true;
        int row = 0;

        for(int i = 0 ; i < rows ; i++) arr[i] = "";

        for(int i = 0 ; i < s.length() ; i++){
            if(flag && row!=rows-1){
                arr[row]+=s.charAt(i);
                row++;
            }
            else if(row==rows-1){
                flag = false;
                arr[row]+=s.charAt(i);
                row--;
            }
            else if(!flag && row!=0){
                arr[row]+=s.charAt(i);
                row--;
            }
            else if(row==0){
                flag = true;
                arr[row]+=s.charAt(i);
                row++;
            }
        }
        for(String i : arr){
            System.out.print(i);
        }
    }
}
