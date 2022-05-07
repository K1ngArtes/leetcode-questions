class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        String[] sorted = new String[strs.length];
        for(int i = 0; i < sorted.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            sorted[i] = new String(c);
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if(!map.containsKey(sorted[i])) {
                List<String> l = new LinkedList<>();
                l.add(s);
                map.put(sorted[i], l);
            } else {
                map.get(sorted[i]).add(s);
            }
        }
        
        List<List<String>> answ = new LinkedList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            answ.add(entry.getValue());
        }
        
        return answ;
    }
}