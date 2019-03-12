import java.util.HashMap;

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int aTracker;
        int bTracker;
        int prevA;
        int prevB;
        int answerA = 0;
        int answerB = 0;
        for (int i = 0; i < A.length - 1; i++) {
            prevA = A[i];
            prevB = B[i];
            aTracker = A[i+1];
            bTracker = B[i+1];

            if (check(prevA, prevB, aTracker, bTracker)){
                answerA++;
            }
            else if (check(prevB, prevA, bTracker, aTracker){
                answerB++;
            }
            else{
                return -1;
            }
        }
        return answer;
    }

    public boolean check(int a, int b, int a2, int b2) {
        if (a!=a2) {
            if((a==b2)||(a2==b)){
                return true;
            }
        }
        return false;
    }
}

HashMap<Integer, Integer> aTracker = new HashMap<>();
HashMap<Integer, Integer> bTracker = new HashMap<>();

for (int i = 0; i < A.length; i++) {
    aTracker.putIfAbsent(A[i], 0);
    aTracker.put(A[i], aTracker.get(A[i] + 1));
    bTracker.putIfAbsent(B[i], 0);
    bTracker.put(B[i], aTracker.get(B[i] + 1));
}
int numClosest = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

if ()