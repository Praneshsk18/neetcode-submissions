class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int i : piles){
            if(i>right){
                right = i;
            }
        }
        while(left < right){
            int mid = (left+right) / 2;
            int hours = 0;
            for(int i : piles){
                hours += (int) Math.ceil((double) i / mid);
            }
            if(hours <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
