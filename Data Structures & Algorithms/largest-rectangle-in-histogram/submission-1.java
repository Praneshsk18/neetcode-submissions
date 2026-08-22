class Solution {
    public int largestRectangleArea(int[] heights) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for(int i=0;i<=n;i++){
            int h = (i==n) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > h){
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                answer = Math.max(answer, height * width);
            }
            stack.push(i);
        }
        return answer;
    }
}
