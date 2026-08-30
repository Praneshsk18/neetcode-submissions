class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int i = 0;i < s2.length();i++){
            arr2[s2.charAt(i) - 'a']++;
            if(i - left > s1.length() - 1){
                arr2[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }
        return false;
    }
}
