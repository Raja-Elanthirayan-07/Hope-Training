public class LC345 {
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();
        String vow="aeiouAEIOU";
        int l=0,r=s.length()-1;
        while(l<r){
            while(l<r&&vow.indexOf(arr[l])==-1){
                l++;
            }
            while(l<r&&vow.indexOf(arr[r])==-1){
                r--;
            }
            char temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
    
        }
        return new String(arr);
    }
}
