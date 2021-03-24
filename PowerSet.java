/*
 * Click `Run` to execute the snippet below!
 */

Leetcode #78


//Given an integer array nums of unique elements, return all possible subsets (the power set).

//The solution set must not contain duplicate subsets. Return the solution in any order.

 
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static List<List<Integer>> ans = new ArrayList<>();
  
  public static void main(String[] args) {
    int[] e = {1,2,3};
    System.out.println(getPowerSet(e));
    
    
  }
  
  public static List<List<Integer>> getPowerSet(int[] elements) {
    calculatePath(elements, -1, new ArrayList<Integer>());
    return ans;
  }
  
  public static List<Integer> getPossibles(int[] elements, int index) {
    List<Integer> subarray = new ArrayList<>();
    for (int i = index+1; i<elements.length; i++) {
      subarray.add(elements[i]);
    }
    return subarray;
  }
  
  public static void calculatePath(int[] elements, int index, ArrayList<Integer> tempPath) {
    ArrayList<Integer> cloned = new ArrayList<>(tempPath);
    ans.add(cloned);
    List<Integer> possiblePaths = getPossibles(elements, index);
    if (possiblePaths.size() == 0) {
      return; 
    }
    else {
      for (int i = 0; i<possiblePaths.size(); i++) {
        tempPath.add(possiblePaths.get(i));
        System.out.println("index: " + index + " i: " + i);
        index++;
        calculatePath(elements, index, tempPath);
        tempPath.remove(tempPath.size()-1);
        index--;
      }
    }
    // ArrayList<Integer> empty = new ArrayList<>();
    // ans.add(empty);
    //add the entire elements as list
    return;
  }
  
   public static List<Integer> convertIntToList(int[] elements) {
       List<Integer> converted = new ArrayList<>();
      for (int i = 0; i<elements.length; i++) {
       converted.add(elements[i]);
      }
     return converted;
   }
}

// [1,2,3] -
//Given an integer array nums of unique elements, return all possible subsets (the power set).

//The solution set must not contain duplicate subsets. Return the solution in any order.

// [1,2,3] -> [[1], [2]. [3], [], [1,2], [2,3], [1,3], [1,2,3]]

 