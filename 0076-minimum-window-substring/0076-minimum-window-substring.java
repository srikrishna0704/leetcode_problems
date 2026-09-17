public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Use a hash array for ASCII characters instead of HashMap
        int[] map = new int[256]; 
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            // If it's a target character we still need, increment count
            if (map[rightChar] > 0) {
                count++;
            }
            // Decrement frequency (target chars go to 0, non-target go negative)
            map[rightChar]--;

            // When we have a valid window
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                
                // Put the character back into our map
                map[leftChar]++;
                
                // If it was a required character and it's now > 0, we broke the window
                if (map[leftChar] > 0) {
                    count--;
                }
                
                left++;
            }
            
            right++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}