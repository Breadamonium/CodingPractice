
public int numSquares(int n) {
    int sqrt = (int) Math.floor(Math.sqrt(n)) + 1;
    int[] dp = new int[n+1];
    
    for (int j = 1; j <= n; j++) {
        if (j == 1) {
            dp [j] = 1;
        }
        else {
            int x = (int) Math.floor(Math.sqrt(j));
            if ((x*x) == j) {
               dp[j] = 1; 
            }
            else {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < j; k++) {
                    if ((dp[k] + dp[j-k]) < min) {
                        min = dp[k] + dp[j-k];
                    }
                }
                dp[j] = min;
            }
        }
    }
    return dp[n];
}    