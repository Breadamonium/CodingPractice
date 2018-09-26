//https://leetcode.com/problems/climbing-stairs/description/ #70
class ClimbStairs {

    public int climbStairs(int n) {
        int[] memoized = new int[n+1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        memoized[0] = 0;
        memoized[1] = 1;
        memoized[2] = 2;
        for (int i=3; i<=n; i++) {
            memoized[i] = memoized[i-1] + memoized[i-2];
        }
        return memoized[n];
    }
}