//https://leetcode.com/problems/divide-two-integers/ #29
class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = true;
        boolean negative = false;
        int counter = 0;
        if (dividend >= (int)Math.pow(2, 31) || dividend <= -(int)Math.pow(2, 31)) {
            return (int)Math.pow(2, 31) - 1;
        }
        if (dividend < 0 && divisor < 0) {
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
        }
        else if (divisor < 0 ) {
            divisor = Math.abs(divisor);
            negative = true;
        }
        else if (dividend < 0) {
            dividend = Math.abs(dividend);
            negative = true;
        }
        while(flag) {
            if ((dividend - divisor) >= 0) {
                dividend -= divisor;
                counter++;
            }
            else {
                flag = false;
            }
        }
        if (negative) { 
            return counter*-1;
        } else {
            return counter;
        }
    }
}