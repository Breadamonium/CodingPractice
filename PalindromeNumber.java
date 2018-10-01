//https://leetcode.com/problems/palindrome-number/description/ #9
class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        else {
            return x == getReverse(x);
        }
    }
    
    public int getReverse(int value) {
        int resultNumber = 0;
        for (int i = value; i !=0; i /= 10) {
            resultNumber = resultNumber * 10 + i % 10;
        }
        return resultNumber;        
    }
}