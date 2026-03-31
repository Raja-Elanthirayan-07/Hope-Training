class LC58 {
public int lengthOfLastWord(String s) {
        String[] st = s.split(" ");
        int n = st.length;
        return st[n-1].length();
    }
}
