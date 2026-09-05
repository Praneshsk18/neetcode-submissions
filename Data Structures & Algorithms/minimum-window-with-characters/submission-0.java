class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int need = count.size();

        int resLen = Integer.MAX_VALUE;
        int resStart = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Use intValue() or equals() for Integer object comparisons
            if (count.containsKey(c) && window.get(c).intValue() == count.get(c).intValue()) {
                have++;
            }

            // Contract the window from the left while criteria are met
            while (have == need) {
                int currentLen = right - left + 1;
                if (currentLen < resLen) {
                    resLen = currentLen;
                    resStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (count.containsKey(leftChar) && window.get(leftChar) < count.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + resLen);
    }
}