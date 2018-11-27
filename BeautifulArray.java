// https://leetcode.com/problems/beautiful-array/ #932
class Solution {
    public int[] beautifulArray(int N) {
        int[] answer = new int[N];
        for (int i = 1; i <= N; i++) {
            answer[i-1] = i;
        }
        answer = recursiveChecker(answer);
        return answer;
    }

    public int[] recursiveChecker(int[] theArray) {
        for (int j = 0; j < theArray.length - 2; j++) {
            for (int k = 2; k < theArray.length; k++){
                if ((theArray[(k+j)/2]*2) == (theArray[j] + theArray[k])){
                    recursiveChecker(swap((k+j)/2, k, theArray));
                }
            }
        }
        return theArray;
    }

    public int[] swap(int first, int second, int[]theArray){
        int temp = theArray[first];
        theArray[first] = theArray[second];
        theArray[second] = temp;
        return theArray;
    }
}