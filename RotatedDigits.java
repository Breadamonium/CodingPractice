//https://leetcode.com/problems/rotated-digits/ #788

class Solution {
    public int rotatedDigits(int N) {
        int counter = 0;
        for (int i = 1; i <= N; i++) {
            String current = Integer.toString(i);
            boolean isRotateable = true;
            boolean isDifferent = false;
            String rotated = "";
            for (char x : current.toCharArray()) {
                if (x == '3' || x=='4' || x=='7') {
                    isRotateable = false;
                    break;
                }
                if (x == '2') {
                    isDifferent = true;
                }
                if (x == '5') {
                    isDifferent = true;
                }
                if (x == '6') {
                    isDifferent = true;
                }
                if (x == '9') {
                    isDifferent = true;
                }
            }
            if (isRotateable && isDifferent) {
                counter++;
            }
        }
        return counter;
    }
}