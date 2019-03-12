class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int numNeg = 0;
        int i = 0;
        while(K>0){
            int temp = A[i];
            if((temp==0)){
                break;
            }
            else if ((temp>0) && (K%2==0)){
                K-=2;
            }
            else if ((temp>0) && (K%2==1) && (i!=0)) {
                if (Math.abs(A[i-1])< temp) {
                    K--;
                    int temp2 = A[i-1];
                    A[i-1] = -temp2;
                }
                else {
                    A[i] = -temp;
                    i++;
                    K--;
                }
            }
            else {
                A[i] = -temp;
                i++;
                K--;
            }
        }
        return sum(A);
    }

    public int sum(int[] b) {
        int answer = 0;
        for (int i = 0; i < b.length; i++) { 
            answer += b[i];
        }
        return answer;
    }
}