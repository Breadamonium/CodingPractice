//https://leetcode.com/problems/rotated-digits/ #788

class Solution {
    public int rotatedDigits(int N) {
        int counter = 0;
        for (int i = 1; i <= N; i++) {
            String current = Integer.toString(i);
            boolean isRotateable = true;
            String rotated = "";
            for (char x : current.toCharArray()) {
                if (x == '3' || x=='4' || x=='7') {
                    isRotateable = false;
                    break;
                }
                if (x == '0' || x =='1' || x == '8') {
                    rotated += Character.toString(x);
                }
                if (x == '2') {
                    rotated += "5";
                }
                if (x == '5') {
                    rotated += "2";
                }
                if (x == '6') {
                    rotated += "9";
                }
                if (x == '9') {
                    rotated += "6";
                }
            }
            if (isRotateable && !rotated.equals(current)) {
                counter++;
            }
        }
        return counter;
    }
}