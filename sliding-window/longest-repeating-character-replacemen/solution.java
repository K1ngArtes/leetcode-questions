class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        
        int uniqueCount = 0;
        int left = 0;
        int max = 0;
        int[] count = new int[26];
        for(int right = 0; right < chars.length; right++) {
            char c = chars[right];
            count[c-'A']++;
            uniqueCount = Math.max(uniqueCount, count[c-'A']);
            // min number of replacements in window = size of window - num of most repeated char in window
            int replaceCount = right - left + 1 - uniqueCount;
            if(replaceCount > k) {
                // move the window
                count[chars[left]-'A']--;
                left++;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}