class Solution {
    public int search(int[] nums, int target) {
       if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
           return -1;
       }
        
        int l = 0;
        int r = nums.length - 1;
        while(true) {
            if (l > r) {
                return -1;
            } else if (l == r && nums[l] == target) {
                 return l;   
            } else if (l == r && nums[l] != target) {
                return -1;
            }
            
            int pivot = l + (r - l)/2;
            
            if (target > nums[pivot]) {
                l = pivot+1;
                continue;
            } else {
                if (target == nums[pivot]) {
                    return pivot;
                }
                r = pivot-1;
                continue;
            }
        }
    }
}