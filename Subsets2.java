class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        return helper(answer, nums, current, 0);
    }
    
    public List<List<Integer>> helper(List<List<Integer>> sets, int[] nums, List<Integer> currentTemp, int index) {
        if (index == nums.length) {
            sets.add(currentTemp);
            return sets;
        }
        else {
            sets.addAll(helper(sets, nums, currentTemp, index + 1));
            currentTemp.add(nums[index]);
            sets.addAll(helper(sets, nums, currentTemp, index + 1));
            return sets;
        }
    }
}