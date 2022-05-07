class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        
        List<Integer> indexes = new ArrayList<>();
        if(sChars.length < pChars.length) {
            return indexes;
        }
        
        Map<Character, Integer> pMap = new HashMap<>();
        for(char c : pChars) {
            if(pMap.get(c) == null) {
                pMap.put(c, 1);
            } else {
                pMap.put(c, pMap.get(c) + 1);
            }
        }
        
//         Set<Character> charsMissing = new HashSet<>();
//         for(int i = 0; i < p.length(); i++) {
//             char c = sChars[i];
//             if(pMap.get(c) == nil) {
//                 charsMissing.add(c);
//             }
//         }
        
        Map<Character, Integer> tempMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = sChars[i];
            if(tempMap.get(c) == null) {
                tempMap.put(c, 1);
            } else {
                tempMap.put(c, tempMap.get(c) + 1);
            }
        }
        
        for(int i = 0; i <= sChars.length - pChars.length; i++) {
            if(i != 0) {
                // System.out.println("The map is: " + tempMap);
                char removed = sChars[i-1];
                char added = sChars[i+pChars.length-1];

                tempMap.put(removed, tempMap.get(removed) - 1);
                if(tempMap.get(removed) == 0) {
                    tempMap.remove(removed);
                }
                if(tempMap.get(added) == null) {
                    tempMap.put(added, 1);
                } else {
                    tempMap.put(added, tempMap.get(added) + 1);
                }
            }
            
            if(tempMap.equals(pMap)) {
                indexes.add(i);
            }
        }
        
        return indexes;
    }
}