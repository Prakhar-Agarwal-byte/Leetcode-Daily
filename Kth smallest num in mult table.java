class Solution {
  public int findKthNumber(int m, int n, int k) {
    int low = 1, high = m * n;
    int ans = 0;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (enough(m, n, mid) < k) {
        low = mid + 1;     
      } else {
        ans = mid;
        high = mid - 1;  
      }
    }
    return ans;
  }

  private int enough(int m, int n, int mid) {
    int sum = 0;
    for (int i = 1; i <= m; i++) {
      sum += Math.min(mid / i, n);
    }
    return sum;
  }
}
