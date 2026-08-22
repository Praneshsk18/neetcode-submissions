class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left]+numbers[right] == target){
                int[] arr = {left+1,right+1};
                return arr;
            }else if(numbers[left]+numbers[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return null;
    }
}
