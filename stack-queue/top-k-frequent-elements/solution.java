class Solution {
    private class NumToFreq {
        int num;
        int f;
        
        NumToFreq(int num, int f) {
            this.f = f;
            this.num = num;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fMap = new HashMap<>();
        
        for(int n : nums) {
            if(fMap.get(n) == null) {
                fMap.put(n, 1);
            } else {
                fMap.put(n, fMap.get(n) + 1);
            }
        }
        
        PriorityQueue<NumToFreq> q = new PriorityQueue<NumToFreq>((a, b) -> {
            return b.f - a.f;
        });
        
        for(Map.Entry<Integer, Integer> e : fMap.entrySet()) {
            q.add(new NumToFreq(e.getKey(), e.getValue()));
        }
        
        int[] answers = new int[k];
        for(int i = 0; i < k; i++) {
            if(q.isEmpty()) {
                break;
            }
            answers[i] = q.remove().num;
        }
        
        return answers;
    }
}