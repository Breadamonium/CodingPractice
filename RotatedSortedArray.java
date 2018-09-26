//https://leetcode.com/problems/search-in-rotated-sorted-array/description/ #33
class RotatedSortedArray {
    public int search(int[] nums, int target) {

    }
    
    public int helper (int[] nums, int target, int startIndex, int endIndex) {
    
        if (nums[mid] > nums[start] && target < nums[start]){
            return helper(nums,target,mid+1,end);
        }
        else if (nums[mid] < nums[start] && target > nums[start]) {
            return helper(nums,target, start,mid-1);
        }
        else if(nums[mid] > nums[start] && target > nums[mid]} }
            return helper(nums, target, middle, nums.length);
        }
        else if (nums[mid] < nums[start] && target > nums[mid]) {
            return helper(nums, Target, 0, mid);
        }
        else {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            return -1;
        }
    }
}