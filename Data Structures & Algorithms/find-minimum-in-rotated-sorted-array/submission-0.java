class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right], minimum is at mid or to the left
                right = mid;
            }
        }

        return nums[left]; // Returns the minimum element value
    }
}