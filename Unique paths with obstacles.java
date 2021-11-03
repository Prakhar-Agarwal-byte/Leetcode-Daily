class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length, m = obstacleGrid[0].length;
    int[][] dp = new int[n][m];
    boolean foundObs = false;
    for (int i = n - 1; i >= 0; i--) {
      if (foundObs) {
        dp[i][m - 1] = 0;
      } else {
        if (obstacleGrid[i][m - 1] == 1) {
          foundObs = true;
          dp[i][m - 1] = 0;
        } else {
          dp[i][m - 1] = 1;
        }
      }
    }
    foundObs = false;
    for (int i = m - 1; i >= 0; i--) {
      if (foundObs) {
        dp[n - 1][i] = 0;
      } else {
        if (obstacleGrid[n - 1][i] == 1) {
          foundObs = true;
          dp[n - 1][i] = 0;
        } else {
          dp[n - 1][i] = 1;
        }
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = m - 2; j >= 0; j--) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
        }
      }
    }
    return dp[0][0];
  }
}
