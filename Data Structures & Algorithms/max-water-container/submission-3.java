class Solution {
    public int maxArea(int[] heights) {
        if(heights.length==2){
            return Math.min(heights[0],heights[1]);
        }
        int area = 1;
        int d = heights.length-1;
        int left = 0;
        int right = heights.length-1;
        while(left<right){
            int min = Math.min(heights[left],heights[right]);
            int tArea = min * d;
            if(area < tArea){
                area = tArea;
            }
            if(heights[left]<heights[right]){
                left++;
                d--;
            }else{
                right--;
                d--;
            }
        }
        return area;
    }
}
