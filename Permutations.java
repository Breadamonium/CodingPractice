import java.util.ArrayList;

//https://leetcode.com/problems/permutations/ #46

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return recursiveHelper(nums);
    }
    
    public List<List<Integer>> recursiveHelper(int[] nums) {
        List<List<Integer>> theAnswer = new ArrayList<>();
        if (nums.length == 1) {
            ArrayList<Integer> curranswer = new ArrayList<Integer>();
            curranswer.add(nums[0]);
            theAnswer.add(curranswer);
            return theAnswer;
        }
        else if (nums.length == 2) {
            ArrayList<Integer> curranswer = new ArrayList<Integer>();
            curranswer.add(nums[0]);
            curranswer.add(nums[1]);
            theAnswer.add(curranswer);
            ArrayList<Integer> nextanswer = new ArrayList<Integer>();
            nextanswer.add(nums[1]);
            nextanswer.add(nums[0]);
            theAnswer.add(nextanswer);
            //System.out.println(Arrays.toString(curranswer.toArray()));
            return theAnswer;
        }
        else {
            for (int j = 0; j<nums.length; j++) {
                int first = nums[j];
                int[] smallerArray = removeTheElement(nums, j);
                //System.out.println(Arrays.toString(smallerArray));
                //System.out.println(Arrays.toString(recursiveHelper(smallerArray)));
                for(List<Integer> aPerm : recursiveHelper(smallerArray)) {
                    List<Integer> curranswer = new ArrayList<Integer>();
                    curranswer.add(first);
                    System.out.println(Arrays.toString(aPerm.toArray()));
                    curranswer.addAll(aPerm);
                    theAnswer.add(curranswer);
                }
            }
            return theAnswer;
        }
    }

    public static int[] removeTheElement(int[] arr, int index) { 

        // If the array is empty 
        // or the index is not in array range 
        // return the original array 
        if (arr == null
        || index < 0
        || index >= arr.length) { 

        return arr; 
        } 

        // Create another array of size one less 
        int[] anotherArray = new int[arr.length - 1]; 

        // Copy the elements except the index 
        // from original array to the other array 
        for (int i = 0, k = 0; i < arr.length; i++) { 

        // if the index is 
        // the removal element index 
        if (i == index) { 
        continue; 
        } 

        // if the index is not 
        // the removal element index 
        anotherArray[k++] = arr[i]; 
        } 

        // return the resultant array 
        return anotherArray; 
    }
}