https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem

import java.util.*;

public class Solution {

    public static int fibonacci(int n) {
    
      int first = 0;
      int second = 1;
      int total = 0;
      
      if (n > 2) {
        for (int i = 0; i < n; n++) {
          total = first + second;
          first = second;
          second = total;
        }
      } else if (n == 0) return 0;
      else if (n == 1) return 1;

      return total;
        
    }
    memorization;
    memoization;
    ArrayList<int> storedValues = new ArrayList<>();
    public static int fibonacci(int n) {
    	int count = 0;
    	if (n == 0) {
      	storedValues.add(0);
      	return 0;
      }
      else if (n == 1) {
      	storedValues.add(1);
      	return 1;
      }
      else {
      	if(storedValues.get(n-1)==null) {
        	storedvalues.add(fibonacci(n-1) + fibonnaci(n-2));
          return fibonacci(n-1) + fibonnaci(n-2);
        }
      	else{
        	return storedValues.get(n-1) + storedValues.get(n-2);
        }
      }
    }

fibonacci(4) -> fibonacci(3) + fibonacci(2);
								/																\
							/																		\
						 /																		\
				fibonacci(2) + fibonacci(1)								fibonacci(1) + fibonacci(0)									
							

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
        
      //  Solution.fibonacci(3); <- static function means the function is a CLASS's function so u can just use it for the class
       // Solution object= new Solution();
       // object.fibonacci(3); <- non static means only OBJECTS of that class can use it.
    }
}