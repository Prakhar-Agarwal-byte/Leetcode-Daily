import java.util.*;

class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    int[] pre = new int[nums.length];
    int max = 0, idx = -1;
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
      pre[i] = -1;  
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            pre[i] = j;
          }
        }
      }
      if (dp[i] > max) {
        max = dp[i];
        idx = i;
      }
    }
    ArrayList<Integer> res = new ArrayList<>();
    while (idx != -1) {
      res.add(nums[idx]);
      idx = pre[idx];
    }
    return res;
  }
}
