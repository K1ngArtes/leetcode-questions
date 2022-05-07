class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        for(char c:sChar) {
            if(sMap.get(c) == null) {
                sMap.put(c, 1);
            } else {
                int lol = sMap.get(c)+1;
                sMap.put(c, lol);
            }
        }
        
        boolean containsAllLetters = true;
        for (char c:tChar) {
            containsAllLetters = containsAllLetters && sMap.containsKey(c) && sMap.get(c) > 0;
            if(containsAllLetters) {
                sMap.put(c, sMap.get(c)-1);
            }
        }
        
        return containsAllLetters && (s.length() == t.length());
    }
}