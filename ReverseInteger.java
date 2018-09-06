//https://leetcode.com/problems/reverse-integer/description/
//didn't think of longs to account for integer overflow
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ReverseInteger {
    public int reverse(int x) {
        char [] charsInNum = String.valueOf(x).toCharArray();
        int reversed = 0;
        boolean negative = false;
        for (int i = charsInNum.length - 1; i >= 0; i--) {
            if (charsInNum[i] == '-') {
                negative = true;
            }
            else {
                double convertedI = (double) i;
                int currentDigit = (int)Math.pow(10.0, convertedI)* Integer.parseInt(String.valueOf(charsInNum[i]));
                reversed += currentDigit;
            }
        }
        if(negative) {
            System.out.println(reversed);
            reversed = (reversed - 2*(reversed))/10;
        }
        return reversed;
    }
}