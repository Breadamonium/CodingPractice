// Leetcode #374 https://leetcode.com/problems/guess-number-higher-or-lower/
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

      public class Solution extends GuessGame {

        public int guessNumber(int n) {
            int upper = n;
            int lower = 1;
            return helperRecursive(lower, upper);
        }

        public int helperRecursive(int lower, int upper) {
            int middle = ((upper - lower)/2) + lower;
            int myGuess = guess(middle);
            if (myGuess == 0 ){
                return middle;
            }
            else if (myGuess == -1){
                return helperRecursive(lower, middle);
            }
            else {
                return helperRecursive(middle, upper);
            }
        }
    }