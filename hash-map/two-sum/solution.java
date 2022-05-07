class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> imap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            imap.put(target - nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(imap.get(num) != null && imap.get(num) != i) {
                return new int[]{i, imap.get(num)};
            }
        }
        
        return new int[2];
    }
}