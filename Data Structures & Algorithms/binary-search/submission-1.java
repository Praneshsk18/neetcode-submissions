class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int p = (left+right)/2;
            int val = nums[p];
            if(val == target){
                return p;
            }else if(val < target){
                left = p+1;
            }else{
                right = p-1;
            }
        }
        return -1;
    }
}
