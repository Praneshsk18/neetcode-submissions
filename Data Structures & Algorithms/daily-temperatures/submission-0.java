class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] arr = new int[l];
        Stack<Integer> stack = new Stack<>();
        for(int i = l-1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            arr[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return arr;
    }
}
