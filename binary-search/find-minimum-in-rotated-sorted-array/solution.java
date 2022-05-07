class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int l = 0;
        int r = nums.length - 1;
        while(true) {
            if(r - l == 1) {
                if (nums[r] > nums[l]) {
                    return nums[l];
                } else {
                    return nums[r];
                }
            }
            int p = l + (r-l)/2;
            
            int num = nums[p];
            
            if(nums[l] < num && nums[l] < nums[r]) {
                return nums[l];
            }
            
            
            if(nums[l] > nums[r]) {
                if(nums[l] > num) {
                    r = p;
                } else {
                    l = p;
                }
            } else {
                r = p;
            }
        }
    }
}