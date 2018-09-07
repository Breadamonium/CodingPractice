
class HouseRobber {
    public int rob(int[] nums) {
        int[] maxCash = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        maxCash[0] = nums[0];
        maxCash[1] = (nums[1] > nums[0])?  nums[1] : nums[0];
        for (int i=2; i <nums.length; i++){
            maxCash[i] = Math.max(maxCash[i-2] +  nums[i] , maxCash[i-1]);
        
        }
       
        int maxInt = 0;
        for (int j = 0; j < maxCash.length; j++) {
            if (maxCash[j] >= maxInt) {
                maxInt = maxCash[j];
            }
        }
        return maxInt;
    }
}
