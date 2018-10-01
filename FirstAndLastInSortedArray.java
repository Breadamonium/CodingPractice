class FirstAndLastInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        
        int start = binarySearch(nums, target, 0, nums.length-1);
        int finish = binarySearch(nums, target, 0 , nums.length-1);
        boolean flagStart = true;
        boolean flagEnd = true;
        int tempStart = start;
        int tempEnd = finish;
        while(flagStart) {
            start = binarySearch(nums, target, 0, start);
            if (start==-1) {
                flagStart = false;
            }
            else {
                tempStart = start;
            }
        }
        while(flagEnd) {
            finish = binarySearch(nums,target, finish, nums.length-1);
            if (finish == -1){
                flagEnd = false;
            }
            else {
                tempEnd = finish;
            }
        }
        int[] answer = new int[2];
        answer[0] = tempStart;
        answer[1] = tempEnd;
        return answer;
    }
    
    public static int binarySearch(int[] nums, int target, int start, int end) {
        int current = (end + start) / 2;
        if (start==end) {
            return -1;
        }
        if (nums[current] < target) {
            return binarySearch(nums, target, current+1, end);
        }
        else if (nums[current] > target) {
            return binarySearch(nums, target, start, current-1);
        }
        else {
             return current;
        }
    }
}