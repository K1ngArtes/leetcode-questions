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
            }
            
            int p = l + (r-l)/2;
            
            int num = nums[p];
            if(num == target) {
                return p;
            }
            if(target == nums[r]) {
                return r;
            } else if(target == nums[l]) {
                return l;
            }
            
            if(target > num) {
                if(target < nums[r]) {
                    l = p+1;
                } else {
                    if(nums[l] < num) {
                        l = p+1;
                    } else {
                        r = p-1;
                    }
                }
            } else {
                if(target > nums[l]) {
                    r = p-1;
                } else {
                    if (nums[r] > num) {
                        r = p-1;
                    } else {
                        l = p+1;
                    }
                }
            }
        }
    }
}