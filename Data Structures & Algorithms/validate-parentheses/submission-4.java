class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        map.putIfAbsent('(', ')');
        map.putIfAbsent('{', '}');
        map.putIfAbsent('[', ']');
        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        for(Character ch : c){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                Character temp = st.pop();
                if(map.get(temp) != ch){
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
