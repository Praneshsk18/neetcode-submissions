class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(isint(s)){
                stack.push(Integer.parseInt(s));
            }else{
                int b = stack.pop();
                int a = stack.pop();
                switch(s){
                    case "+" : stack.push(a+b); break;
                    case "-" : stack.push(a-b); break;
                    case "*" : stack.push(a*b); break;
                    case "/" : stack.push(a/b); break;
                }
            }
        }
        return stack.pop();
    }
    public static boolean isint(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
