/**
https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
First Solution I could think of for this problem. Optimizations I would do
if I had time building on my solution include, reducing the hashmaps used to one, or perhaps 
even none, and using arrayLists instead. Reducing the number of for loops and consolidating logic 
so no need to put the strings into a hashmap, just to iterate over them again to count them**/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> firstCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> secondCount = new HashMap<Character, Integer>();
        for(char x : first.toCharArray()) {
            if (firstCount.containsKey(x)) {
                int numOfThisLetter = firstCount.get(x);
                firstCount.put(x, numOfThisLetter + 1);
            }
            else {
                firstCount.put(x, 1);
            }
        }
        for(char y : second.toCharArray()) {
            if (secondCount.containsKey(y)) {
                int numOfThisOtherLetter = secondCount.get(y);
                secondCount.put(y, numOfThisOtherLetter + 1);
            }
            else {
                secondCount.put(y, 1);
            }
        }
        int firstCountSimilarities = 0;
        int secondCountSimilarities = 0;
        for (char aLetter : secondCount.keySet()) {
            if (firstCount.containsKey(aLetter)) {
                int sim = secondCount.get(aLetter)<=firstCount.get(aLetter) ? 
                secondCount.get(aLetter) : firstCount.get(aLetter);
                secondCountSimilarities += sim;
            }
        }
        for (char aLetter : firstCount.keySet()) {
            if (secondCount.containsKey(aLetter)) {
                int sim = firstCount.get(aLetter)<=secondCount.get(aLetter) ? 
                firstCount.get(aLetter) : secondCount.get(aLetter);
                firstCountSimilarities += sim;
            }
        }
        int totalToDelete = (first.length() - firstCountSimilarities) + 
        (second.length() - secondCountSimilarities);
        return totalToDelete;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

/*
Assuming size n string for first and size m string for second.
Runtime Analysis: First two for loops insert each character of the string into their respective hashmaps, takes O(n+m) 
time to iterate through each string. Then next two for loops iterate through hashmaps, retrieving their values to 
determine the count of each character, taking O(n+m) again. Hashmap retrievals are simply O(1) so they are not counted.
Finally the calculation of the exact number of differences in letters to remove is also O(1).
Total runtime: O(n+m+n+m) = O(2n + 2m) ~ approximately still O(N) time at maximum.
Space Complexity: Hashmaps each take up O(n) + O(m) space. Maximum space needed is O(n+m).
Optimization Analysis: Really only need one Hashmap to track changes, instead use one string and add characters to 
hashmap, while the other string decrements from the values in the hashmap, and use counter to keep track of differences.
Most upvoted solutions on Hackerrank simply use arrays/vectors and iterate throught the strings themselves to reduce
space used.
*/