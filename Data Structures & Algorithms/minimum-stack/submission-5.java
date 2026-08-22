class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mStack;
    public MinStack() {
        stack = new Stack();
        mStack = new Stack();
    }
    
    public void push(int val) {
        int mintop = val;
        if(!stack.isEmpty()){
            mintop = mStack.peek();
        }
        mStack.push(Math.min(mintop,val));
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        mStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mStack.peek();
    }
}
