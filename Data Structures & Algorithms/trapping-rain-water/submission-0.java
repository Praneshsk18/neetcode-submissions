class Solution {
    public int trap(int[] height) {
        int[] pre = new int[height.length];
        int[] suf = new int[height.length];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            pre[i] = Math.max(height[i], max);
            if (height[i] > max) {
                max = height[i];
            }
        }
        max = 0;
        for (int i = height.length-1; i > 0; i--) {
            suf[i] = Math.max(height[i], max);
            if (height[i] > max) {
                max = height[i];
            }
        }
        for(int i=1;i<height.length-1;i++){
            int val = Math.min(pre[i],suf[i]) - height[i];
            ans += val;
        }
        return ans;
    }
}
