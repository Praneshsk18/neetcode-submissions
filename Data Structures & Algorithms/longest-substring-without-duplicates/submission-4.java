class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int best = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i< s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(i));
            best = Math.max(best,set.size());
        }
        return best;
    }
}
