import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//#78 https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> duplicate = new HashSet<List<Integer>>();
        List<List<Integer>> answer = new ArrayList<>();
        for (int numToRemove = 0; numToRemove<nums.length; numToRemove++){
            int[] downArray = removeTheElement(nums, numToRemove);
            duplicate.add(downArray);
        }
        HashSet<List<Integer>> duplicates = recursive(duplicate, nums);
        for (List<Integer> aSet : duplicates) {
            answer.add(aSet);
        }
    }
    public HashSet<List<Integer>> recursive(HashSet<List<Integer>> seen, int[] toCheck) {
        HashSet<List<Integer>> duplicates = 
        for (int i = 0; i<toCheck.length; i++){
            int[] downArray = removeTheElement(toCheck, i);
            seen.add(downArray);
            return seen;
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
