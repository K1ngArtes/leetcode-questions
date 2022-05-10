class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        char[] chars = s.toCharArray();
        Map<Character, Integer> pMap = new HashMap<>();
        for(int l = 0; l < s.length(); l++) {
            char c = chars[l];
            pMap.put(c, l);
        }
        
        int theFurthest = -1;
        while(j < chars.length) {
            char c = chars[j];
            int furthestI = pMap.get(c);
            
            if(furthestI > theFurthest) {
                theFurthest = furthestI;
            }
            if(j == theFurthest) {
                answer.add(j - i + 1);
                j++;
                i = j;
                theFurthest = -1;
            } else {
                j++;
            }
        }
        
        return answer;
    }
}