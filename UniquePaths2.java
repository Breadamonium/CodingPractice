//https://leetcode.com/problems/unique-paths-ii/solution/ #63

class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] numWays = new int[row][col];

        for (int i = col - 1; i >= 0; i--) {
            if(obstacleGrid[row - 1][i] == 0) {
                numWays[row - 1][i] = 1;
            }
            else {
                numWays[row - 1][i] = 0;
                break;
            }
        }
        for (int j = row - 1; j >= 0; j--) {
            if (obstacleGrid[j][col - 1] == 0) {
                numWays[j][col - 1] = 1;
            }
            else {
                numWays[j][col - 1] = 0;
                break;
            }
        }
        
        for (int x = col - 2; x >= 0; x--) {
            for (int y = row - 2; y >=0; y--) {
                if (obstacleGrid[y][x] == 1) {
                    numWays[y][x] = 0;
                }
                else {
                    numWays[y][x] = numWays[y+1][x] + numWays[y][x+1];
                }
            }
        }
        return numWays[0][0];
    }
}