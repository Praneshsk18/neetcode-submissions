class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String s : strs){
            st.append(s.length()+"#"+s);
        }
        return st.toString();
    }

    public List<String> decode(String str) {
        List<String> l = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int ptr = str.indexOf("#",i);
            int len = Integer.parseInt(str.substring(i,ptr));
            i = ptr + 1;
            String s = str.substring(i, i + len);
            l.add(s);
            i+=len;
        }
        return l;
    }
}
