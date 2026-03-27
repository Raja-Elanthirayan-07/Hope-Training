class LC557 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for(String rev:words){
            StringBuilder tmp = new StringBuilder(rev);
            res.append(tmp.reverse().toString()).append(" ");    
        }
        return res.toString().trim();
        
    }
}