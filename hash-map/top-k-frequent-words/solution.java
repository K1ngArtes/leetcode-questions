class Solution {
    class StringOcc {
        String str;
        int occur;
        
        StringOcc(String str, int occur) {
            this.str = str;
            this.occur = occur;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> fMap = new HashMap<>();
        
        for(String w : words) {
            if(fMap.get(w) == null) {
                fMap.put(w, 1);
            } else {
                fMap.put(w, fMap.get(w) + 1);
            }
        }
        
        PriorityQueue<StringOcc> q = new PriorityQueue<StringOcc>((a, b) -> {
            if(a.occur == b.occur) {
                return a.str.compareTo(b.str);
            }
            return b.occur - a.occur;
        });
        for(Map.Entry<String, Integer> e : fMap.entrySet()) {
            q.add(new StringOcc(e.getKey(), e.getValue()));    
        }
        
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            StringOcc oc = q.remove();
            answer.add(oc.str);
        }
        return answer;
    }
}