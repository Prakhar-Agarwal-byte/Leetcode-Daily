import java.util.Arrays;

class Solution {
  public int numTrees(int n) {
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    return util(n, dp);
  }

  private int util(int n, int[] dp) {
    if (n < 2)
      return 1;
    if (dp[n] != -1)
      return dp[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
      res += util(i, dp) * util(n - i - 1, dp);
    }
    return dp[n] = res;
  }
}
